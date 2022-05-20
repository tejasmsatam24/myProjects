#!/bin/sh
for K in 3000 5000 2000;
do
for O in 400 300 500;
do
  for species in CHIMP DOG MOUSE;
  do
    echo aligning HUMAN and $species for K=$K O=$O...
    ./blastz HUMAN $species K=$K O=$O \
    | ./lav2maf /dev/stdin HUMAN $species \
    | ./single_cov2 /dev/stdin R=HUMAN \
    | ./maf_project /dev/stdin HUMAN \
    > HUMAN.$species.L$L.O$O.maf
    ../pr3 HUMAN.$species.align.true.fa HUMAN.$species.L$L.O$O.maf 5
    ../pr3 HUMAN.$species.align.true.fa HUMAN.$species.L$L.O$O.maf 0
    echo
  done
done
done
