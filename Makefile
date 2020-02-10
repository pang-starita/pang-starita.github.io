
all: so_intro.pdf


%.pdf: %.md %_h.md
	pandoc -t beamer --slide-level=2 -f markdown $*_h.md $< -o $@

