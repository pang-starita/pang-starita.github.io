@echo off

pandoc -s -t latex -f markdown -o resumoC.pdf --var papersize:a4 -V geometry:margin=1in resumoC.md 
pandoc -s -t html -f markdown -o resumoC.html resumoC.md
