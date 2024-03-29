# $Id: Makefile.in,v 1.33 2010/08/09 01:09:28 sjg Exp $
#
# $NetBSD: Makefile,v 1.28 2010/04/22 21:41:11 sjg Exp $
#
# Unit tests for make(1)
# The main targets are:
# 
# all:	run all the tests
# test:	run 'all', capture output and compare to expected results
# accept: move generated output to expected results
#
# Adding a test case.  
# Each feature should get its own set of tests in its own suitably
# named makefile which should be added to SUBFILES to hook it in.
# 

srcdir= /home/cheusov/prjs/debs/bmake-20100911/unit-tests

.MAIN: all

UNIT_TESTS:= ${srcdir}

# Simple sub-makefiles - we run them as a black box
# keep the list sorted.
SUBFILES= \
	comment \
	cond1 \
	error \
	export \
	export-all \
	doterror \
	dotwait \
	forsubst \
	moderrs \
	modmatch \
	modmisc \
	modorder \
	modts \
	modword \
	posix \
	qequals \
	ternary \
	unexport \
	unexport-env \
	varcmd

all: ${SUBFILES}

flags.doterror=

# the tests are actually done with sub-makes.
.PHONY: ${SUBFILES}
.PRECIOUS: ${SUBFILES}
${SUBFILES}:
	-@${.MAKE} ${flags.$@:U-k} -f ${UNIT_TESTS}/$@

clean:
	rm -f *.out *.fail *.core

.-include <bsd.obj.mk>

TEST_MAKE?= ${.MAKE}
TOOL_SED?= sed
TOOL_TR?= tr
TOOL_DIFF?= diff
DIFF_FLAGS?= -u

# ensure consistent results from sort(1)
LANG= C
.export LANG

# ensure consistent results from sort(1)
LANG= C
.export LANG

# The driver.
# We always pretend .MAKE was called 'make' 
# and strip ${.CURDIR}/ from the output
# and replace anything after 'stopped in' with unit-tests
# so the results can be compared.
test:
	@echo "${TEST_MAKE} -f ${MAKEFILE} > ${.TARGET}.out 2>&1"
	@cd ${.OBJDIR} && ${TEST_MAKE} -f ${MAKEFILE} 2>&1 | \
	${TOOL_TR} -d '\015' | \
	${TOOL_SED} -e 's,^${TEST_MAKE:T:C/\./\\\./g}:,make:,' \
	-e '/stopped/s, /.*, unit-tests,' \
	-e 's,${.CURDIR:C/\./\\\./g}/,,g' \
	-e 's,${UNIT_TESTS:C/\./\\\./g}/,,g' > ${.TARGET}.out || { \
	tail ${.TARGET}.out; mv ${.TARGET}.out ${.TARGET}.fail; exit 1; }
	${TOOL_DIFF} ${DIFF_FLAGS} ${UNIT_TESTS}/${.TARGET}.exp ${.TARGET}.out

accept:
	mv test.out ${srcdir}/test.exp

