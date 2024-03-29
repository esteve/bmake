# RCSid:
#	$Id: makefile.boot.in,v 1.4 2008/02/16 01:07:51 sjg Exp $

srcdir=/home/cheusov/prjs/debs/bmake-20091118/lst.lib
VPATH=.:$(srcdir)

OBJ=lstAppend.o lstDupl.o lstInit.o lstOpen.o lstAtEnd.o lstEnQueue.o \
    lstInsert.o lstAtFront.o lstIsAtEnd.o lstClose.o lstFind.o lstIsEmpty.o \
    lstRemove.o lstConcat.o lstFindFrom.o lstLast.o lstReplace.o lstFirst.o \
    lstDatum.o lstForEach.o lstMember.o lstSucc.o lstDeQueue.o \
    lstForEachFrom.o lstDestroy.o lstNext.o lstPrev.o

CFLAGS=-Wall -g -O2 -I..
all: ${OBJ}

depend:
	VPATH=${VPATH} ${MKDEP} -f makefile.boot ${CFLAGS} ${OBJ:.o=.c}

#lstAppend.o: $(srcdir)/lstAppend.c
#lstDupl.o: $(srcdir)/lstDupl.c
#lstInit.o: $(srcdir)/lstInit.c
#lstOpen.o: $(srcdir)/lstOpen.c
#lstAtEnd.o: $(srcdir)/lstAtEnd.c
#lstEnQueue.o: $(srcdir)/lstEnQueue.c
#lstInsert.o: $(srcdir)/lstInsert.c
#lstAtFront.o: $(srcdir)/lstAtFront.c
#lstIsAtEnd.o: $(srcdir)/lstIsAtEnd.c
#lstClose.o: $(srcdir)/lstClose.c
#lstFind.o: $(srcdir)/lstFind.c
#lstIsEmpty.o: $(srcdir)/lstIsEmpty.c
#lstRemove.o: $(srcdir)/lstRemove.c
#lstConcat.o: $(srcdir)/lstConcat.c
#lstFindFrom.o: $(srcdir)/lstFindFrom.c
#lstLast.o: $(srcdir)/lstLast.c
#lstReplace.o: $(srcdir)/lstReplace.c
#lstFirst.o: $(srcdir)/lstFirst.c
#lstDatum.o: $(srcdir)/lstDatum.c
#lstForEach.o: $(srcdir)/lstForEach.c
#lstMember.o: $(srcdir)/lstMember.c
#lstSucc.o: $(srcdir)/lstSucc.c
#lstDeQueue.o: $(srcdir)/lstDeQueue.c
#lstForEachFrom.o: $(srcdir)/lstForEachFrom.c
#lstDestroy.o: $(srcdir)/lstDestroy.c
#lstNext.o: $(srcdir)/lstNext.c
