#!/bin/sh
files=$(find $1 -name "*.md")
# echo $(dirname ${0})
parentdir=${0%/*}
for f in $files; do
    echo $f
    python $parentdir/formatter.py $f $2
done
