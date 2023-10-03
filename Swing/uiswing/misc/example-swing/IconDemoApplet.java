import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Vector;
import java.util.StringTokenizer;

public class IconDemoApplet extends JApplet 
                            implements ActionListener {
    Vector pictures;

    JButton previousButton;
    JButton nextButton;
    JLabel photographLabel;
    JLabel captionLabel;
    JLabel numberLabel;

    int current = 0;
    int widthOfWidest = 0;
    int heightOfTallest = 0;

    String imagedir = null;

    public void init() {
        //Parse the applet parameters
        pictures = parseParameters();

        //If the applet tag doesn't provide an "IMAGE0" parameter,
        //display an error message.
        if (pictures.size() == 0) {
            captionLabel = new JLabel("No images listed in applet tag.");
            captionLabel.setHorizontalAlignment(JLabel.CENTER);
            getContentPane().add(captionLabel);
            return;
        }

        //NOW CREATE THE GUI COMPONENTS

        //A label to identify XX of XX.
        numberLabel = new JLabel("Picture " + (current+1) +
                                 " of " + pictures.size());
        numberLabel.setHorizontalAlignment(JLabel.LEFT);
        numberLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 5));

        //A label for the caption.
        final Photo first = (Photo)pictures.firstElement();
        captionLabel = new JLabel(first.caption);
        captionLabel.setHorizontalAlignment(JLabel.CENTER);
        captionLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        //A label for displaying the photographs.
        photographLabel = new JLabel("Loading first image...");
        photographLabel.setHorizontalAlignment(JLabel.CENTER);
        photographLabel.setVerticalAlignment(JLabel.CENTER);
        photographLabel.setVerticalTextPosition(JLabel.CENTER);
        photographLabel.setHorizontalTextPosition(JLabel.CENTER);
        photographLabel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLoweredBevelBorder(),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        photographLabel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(0, 0, 10, 0),
                        photographLabel.getBorder()
        ));

        //Set the preferred size for the picture,
        //with room for the borders.
        Insets i = photographLabel.getInsets();
        photographLabel.setPreferredSize(new Dimension(
                            widthOfWidest+i.left+i.right,
                            heightOfTallest+i.bottom+i.top));

        //Create the next and previous buttons.
        ImageIcon nextIcon = new ImageIcon(
                getURL(imagedir + "right.gif"));
        ImageIcon dimmedNextIcon = new ImageIcon(
                getURL(imagedir + "dimmedRight.gif"));
        ImageIcon previousIcon = new ImageIcon(
                getURL(imagedir + "left.gif"));
        ImageIcon dimmedPreviousIcon = new ImageIcon(
                getURL(imagedir + "dimmedLeft.gif"));

        previousButton = new JButton("Previous Picture",
                                     previousIcon);
        previousButton.setDisabledIcon(dimmedPreviousIcon);
        previousButton.setVerticalTextPosition(AbstractButton.CENTER);
        previousButton.setHorizontalTextPosition(AbstractButton.RIGHT);
        previousButton.setMnemonic(KeyEvent.VK_P);
        previousButton.setActionCommand("previous");
        previousButton.addActionListener(this);
        previousButton.setEnabled(false);

        nextButton = new JButton("Next Picture", nextIcon);
        nextButton.setDisabledIcon(dimmedNextIcon);
        nextButton.setVerticalTextPosition(AbstractButton.CENTER);
        nextButton.setHorizontalTextPosition(AbstractButton.LEFT);
        nextButton.setMnemonic(KeyEvent.VK_N);
        nextButton.setActionCommand("next");
        nextButton.addActionListener(this);

        //Lay out the GUI.
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        Container contentPane = getContentPane();
        contentPane.setLayout(layout);

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        layout.setConstraints(numberLabel, c);
        contentPane.add(numberLabel);

        layout.setConstraints(captionLabel, c);
        contentPane.add(captionLabel);

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        layout.setConstraints(photographLabel, c);
        contentPane.add(photographLabel);

        c.gridwidth = GridBagConstraints.RELATIVE;
        c.fill = GridBagConstraints.HORIZONTAL;
        layout.setConstraints(previousButton, c);
        contentPane.add(previousButton);

        c.gridwidth = GridBagConstraints.REMAINDER;
        layout.setConstraints(nextButton, c);
        contentPane.add(nextButton);

        //Start loading the image for the first photograph now.
        //The loadImage method uses a SwingWorker
        //to load the image in a separate thread.
        loadImage(imagedir + first.filename, current);
    }

    //User clicked either the next or the previous button.
    public void actionPerformed(ActionEvent e) {
        //Show loading message.
        photographLabel.setIcon(null);
        photographLabel.setText("Loading image...");

        //Compute index of photograph to view.
        if (e.getActionCommand().equals("next")) {
            current += 1;
            if (!previousButton.isEnabled())
                previousButton.setEnabled(true);
            if (current == pictures.size() - 1)
                nextButton.setEnabled(false);
        } else {
            current -= 1;
            if (!nextButton.isEnabled())
                nextButton.setEnabled(true);
            if (current == 0)
                previousButton.setEnabled(false);
        }

        //Get the photo object.
        Photo pic = (Photo)pictures.elementAt(current);

        //Update the caption and number labels.
        captionLabel.setText(pic.caption);
        numberLabel.setText("Picture " + (current+1) +
                            " of " + pictures.size());

        //Update the photograph.
        ImageIcon icon = pic.getIcon();
        if (icon == null) {     //haven't viewed this photo before
            loadImage(imagedir + pic.filename, current);
        } else {
            updatePhotograph(current, pic);
        }
    }

    //Must be invoked from the event-dispatching thread.
    private void updatePhotograph(int index, Photo pic) {
        ImageIcon icon = pic.getIcon();

        photographLabel.setToolTipText(pic.filename + ": " +
                                       icon.getIconWidth() + " X " +
                                       icon.getIconHeight());
        photographLabel.setIcon(icon);
        photographLabel.setText("");
    }

    //Load an image in a separate thread.
    private void loadImage(final String imagePath, final int index) {
        final SwingWorker worker = new SwingWorker() {
            ImageIcon icon = null;

            public Object construct() {
                icon = new ImageIcon(getURL(imagePath));
                return icon; //return value not used by this program
            }

            //Runs on the event-dispatching thread.
            public void finished() { 
                Photo pic = (Photo)pictures.elementAt(index);
                pic.setIcon(icon);
                if (index == current)
                    updatePhotograph(index, pic);
            }
        };
	worker.start();
    }

    protected URL getURL(String filename) {
        URL codeBase = this.getCodeBase();
        URL url = null;

        try {
            url = new URL(codeBase, filename);
        } catch (java.net.MalformedURLException e) {
            System.out.println("Couldn't create image: "
                             + "badly specified URL");
            return null;
        }

        return url;
    }

    protected Vector parseParameters() {
        Vector pix = new Vector(10);    //start with 10, grows if necessary
        int i = 0;                      //parameters index must start at 0
        String paramName = "IMAGE" + i;
        String paramValue;

        while ((paramValue = getParameter(paramName)) != null) {
            Photo pic = new Photo(paramValue, getCaption(i),
                                  getWidth(i), getHeight(i));
            pix.addElement(pic);
            i++;
            paramName = "IMAGE" + i;
        }

        //Get the name of the directory that contains the image files.
        imagedir = getParameter("IMAGEDIR");
        if (imagedir != null)
            imagedir = imagedir + "/";

        return pix;
    }

    protected String getCaption(int i) {
        return getParameter("CAPTION"+i);
    }

    protected int getWidth(int i) {
        int width = 0;
        String widthString = getParameter("WIDTH"+i);
        if (widthString != null) {
            try {
                width = Integer.parseInt(widthString);
            } catch (NumberFormatException e) {
                width = 0;
            }
        } else {
            width = 0;
        }
        if (width > widthOfWidest)
            widthOfWidest = width;
        return width;
    }

    protected int getHeight(int i) {
        int height = 0;
        String heightString = getParameter("HEIGHT"+i);
        if (heightString != null) {
            try {
                height = Integer.parseInt(heightString);
            } catch (NumberFormatException e) {
                height = 0;
            }
        } else {
            height = 0;
        }
        if (height > heightOfTallest)
            heightOfTallest = height;
        return height;
    }

    public String[][] getParameterInfo() {
        String[][] info = {
            {"IMAGEDIR", "string", "directory containing image files" },
            {"IMAGEN", "string", "filename" },
            {"CAPTIONN", "string", "caption" },
            {"WIDTHN", "integer", "width of image" },
            {"HEIGHTN", "integer", "height of image" },
        };
        return info;
    }
}
