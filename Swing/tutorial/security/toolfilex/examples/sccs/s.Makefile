h48270
s 00001/00001/00009
d D 1.2 06/06/26 15:16:52 mb40549 3 1
c j1.2 to j1.6
e
s 00000/00000/00000
d R 1.2 98/08/06 23:19:19 Codemgr 2 1
c SunPro Code Manager data about conflicts, renames, etc...
c Name history : 3 2 security/toolfilex/examples/Makefile
c Name history : 2 1 security/toolfilex/example-1dot2/Makefile
c Name history : 1 0 security1.2/toolfilex/example-1dot2/Makefile
e
s 00010/00000/00000
d D 1.1 98/08/06 23:19:18 maryd 1 0
c date and time created 98/08/06 23:19:18 by maryd
e
u
U
f e 0
t
T
I 1
#
TOP=../../..

include $(TOP)/makefiles/docdefs.mk

D 3
JAVAC=$(JAVAC1.2)
E 3
I 3
JAVAC=$(JAVAC1.6)
E 3

DESTFILES=

include $(MAKEFILE_PATH)/examplerules.mk
E 1
