
/*
 * Copyright (c) 2006 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * -Redistribution of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 *
 * -Redistribution in binary form must reproduce the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 *
 * Neither the name of Sun Microsystems, Inc. or the names of contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 * ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN MIDROSYSTEMS, INC. ("SUN")
 * AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 * AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR ANY LOST
 * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL,
 * INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY
 * OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE,
 * EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * You acknowledge that this software is not designed, licensed or intended
 * for use in the design, construction, operation or maintenance of any
 * nuclear facility.
 */


import java.util.*;

public class RBControl {
    public static void main(String[] args) {
	test(Locale.CHINA);
	test(new Locale("zh", "HK"));
	test(Locale.TAIWAN);
	test(Locale.CANADA);
    }

    private static void test(Locale locale) {
	ResourceBundle rb = ResourceBundle.getBundle("RBControl", locale,
	     new ResourceBundle.Control() {
		 @Override
		 public List<Locale> getCandidateLocales(String baseName, Locale locale) {
		     if (baseName == null)
			 throw new NullPointerException();
		     if (locale.equals(new Locale("zh", "HK"))) {
			 return Arrays.asList(
			     locale,
			     Locale.TAIWAN,
			     // no Locale.CHINESE here
			     Locale.ROOT);
		     } else if (locale.equals(Locale.TAIWAN)) {
			 return Arrays.asList(
			     locale,
			     // no Locale.CHINESE here
			     Locale.ROOT);
		     }
		     return super.getCandidateLocales(baseName, locale);
		 }
	     });
	System.out.println("locale: " + locale);
	System.out.println("\tregion: " + rb.getString("region"));
	System.out.println("\tlanguage: " + rb.getString("language"));
    }
}
