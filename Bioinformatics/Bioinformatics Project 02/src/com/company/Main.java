package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {


        //declaring counter to count the line
        int count_line = 0;
        //declaring string variable to hold the hg19.chr22 gene
        String human_gene;

        //declaring string variable to split the hg19.chr22 gene
        String[] human_gene_split;

        //declaring a string to hold human gene sequence
        String human_gene_sequence;

        //declaring the string variable to hold the whole chromosome
        String human_gene_sequence_all = "";

        //declaring a variable to hold character Array
        char[] human_gene_sequence_all_charArray = {};

        //human gene promoter array
        String human_gene_sequence_promoter_string;

        char[] human_gene_sequence_promoter_array = {};

        //declaring string variable to split the other genes
        String other_gene;

        //declaring string variable to hold the other genes
        String[] other_gene_split;

        //declaring a string to hold other gene sequence
        String other_gene_sequence;

        //declaring the string variable to hold the whole chromosome
        String other_gene_sequence_all = "";

        //declaring variable to hold other gene character array
        char[] other_gene_sequence_all_charArray = {};

        String other_gene_sequence_promoter_string;

        char[] other_gene_sequence_promoter_array = {};

        //creating an array for to split the known gene
        String[] known_gene_split = {};

        //nothing but testing
        String length_of_sequence = "";
        double seq = 0;


        //promoter variables
        double promoter_match = 0;
        double promoter_mismatch = 0;
        double promoters_transition=0;
        double promoters_transversion=0;
        int promoter_gap=0;
        double promoter_gap_rate = 0;
        double promoter_substitution_rate = 0;
        double promoter_ratio = 0;
//        //using map function to calculate the gap frequency
//        Map<Integer, Integer> promoter_indel_Map = new HashMap<Integer, Integer>();

        //exons
        double ex_match = 0;
        double ex_mismatch = 0;
        double ex_transition=0;
        double ex_gap=0;
        double ex_transversion=0;
        double ex_gap_rate = 0;
        double ex_substitution_rate = 0;
        double ex_ratio = 0;

        //5UTR
        double f_UTR_match = 0;
        double f_UTR_mismatch = 0;
        double f_UTR_transition =0;
        double f_UTR_gap = 0;
        double f_UTR_transversion = 0;
        double f_UTR_gap_rate = 0;
        double f_UTR_substitution_rate = 0;
        double f_UTR_ratio = 0;

        //3UTR
        double t_UTR_match = 0;
        double t_UTR_mismatch = 0;
        double t_UTR_transition = 0;
        double t_UTR_gap =0;
        double t_UTR_transversion = 0;
        double t_UTR_gap_rate = 0;
        double t_UTR_substitution_rate = 0;
        double t_UTR_ratio = 0;

        //introns
        double intron_match=0;
        double intron_mismatch=0;
        double intron_transition=0;
        double intron_gap = 0;
        double intron_transversion = 0;
        double intron_gap_rate = 0;
        double intron_substitution_rate = 0;
        double intron_ratio = 0;

        //intergenic
        int intergenic_count=0;
        double intergenic_match=0;
        double intergenic_mismatch=0;
        int previous_ex_end=0;
        double intergenic_transition=0;
        double intergenic_gap=0;
        double intergenic_transversion = 0;
        double intergenic_gap_rate = 0;
        double intergenic_substitution_rate = 0;
        double intergenic_ratio = 0;


        //declaring variables required
        int tx_Start;
        int tx_End;
        int cds_Start;
        int cds_End;
        String ex_Start;
        String ex_End;

        //creating an array to store the exon starts
        String[] ex_Starts_Array = {};

        //int[] ex_Starts_Array_int = {};

        //creating an array to store the exon ends
        String[] ex_Ends_Array = {};

        //int[] ex_Ends_Array_int = {};

         File gene_file = new File("/Users/tejassatam/Desktop/Bioinformatics Project 02 v01/src/com/company/chr22.hg19.panTro4.sing.maf");
        //File gene_file = new File("/Users/tejassatam/Desktop/Bioinformatics Project 02 v02/src/com/company/chr22.hg19.mm10.sing.maf");
        //File gene_file = new File("/Users/tejassatam/Desktop/Bioinformatics Project 02 v02/src/com/company/chr22.hg19.canFam3.sing.txt");

        //read the known gene file
        File known_gene_file = new File("/Users/tejassatam/Desktop/Bioinformatics Project 02 v02/src/com/company/hg19.chr22.knownGene.txt");


        BufferedReader gene_file_br = new BufferedReader(new FileReader(gene_file));

        BufferedReader known_gene_file_br = new BufferedReader(new FileReader(known_gene_file));

        //declaring string to read from file
        String gene_file_str;
        String other_file_str;

        while ((gene_file_str = gene_file_br.readLine()) != null) {
            count_line++;

            if (count_line % 4 == 0) {
                //get the whole human gene data
                human_gene = gene_file_str;

                //System.out.println(human_gene);
                //splitting the human gene
                human_gene_split = human_gene.split("\\s+");

                //we have the human gene sequence
                human_gene_sequence = human_gene_split[human_gene_split.length - 1].toUpperCase();


                human_gene_sequence_all = human_gene_sequence_all + human_gene_sequence;
                //human_gene_sequence_all = human_gene_sequence_all+"a";

                length_of_sequence = human_gene_split[3];

                seq = seq + Double.parseDouble(length_of_sequence);

               // System.out.println(length_of_sequence);


            }//end getting human gene sequence

            if (count_line > 1 && count_line % 4 == 1) {
                other_gene = gene_file_str;

                //splitting the other gene sequence
                other_gene_split = other_gene.split("\\s+");

                //we have the other gene sequence
                other_gene_sequence = other_gene_split[other_gene_split.length - 1].toUpperCase();
                //System.out.println(other_gene_sequence);
                //System.out.println(other_gene_sequence);
                other_gene_sequence_all = other_gene_sequence_all + other_gene_sequence;

            }
        }//end of while, reading file

        human_gene_sequence_all_charArray = human_gene_sequence_all.toCharArray();

        other_gene_sequence_all_charArray = other_gene_sequence_all.toCharArray();

        //System.out.println("Human chromosome : "+human_gene_sequence_all.length());
        // System.out.println("Other chromosome : "+other_gene_sequence_all.length());

        while ((other_file_str = known_gene_file_br.readLine()) != null) {
            known_gene_split = other_file_str.split("\\s+");

            tx_Start = Integer.parseInt(known_gene_split[3]);
            tx_End = Integer.parseInt(known_gene_split[4]);

            cds_Start = Integer.parseInt(known_gene_split[5]);
            cds_End = Integer.parseInt(known_gene_split[6]);

            ex_Start = known_gene_split[8];
            ex_End = known_gene_split[9];


            //System.out.println(ex_End);
            ex_Starts_Array = ex_Start.split(",");
            ex_Ends_Array = ex_End.split(",");

            int[] ex_Start_Array_int = new int[ex_Starts_Array.length];

            for (int i = 0; i < ex_Starts_Array.length; i++) {
                ex_Start_Array_int[i] = Integer.parseInt(ex_Starts_Array[i]);
            }

            int[] ex_End_Array_int = new int[ex_Starts_Array.length];

            for (int i = 0; i < ex_Ends_Array.length; i++) {
                ex_End_Array_int[i] = Integer.parseInt(ex_Ends_Array[i]);
            }

            //calculating promoters
            human_gene_sequence_promoter_string = "";
            other_gene_sequence_promoter_string = "";
            //System.out.println(human_gene_sequence_all_charArray.length);
            if (human_gene_sequence_all_charArray.length > ex_Start_Array_int[0]) {
                for (int i = ex_Start_Array_int[0] - 200; i <= ex_Start_Array_int[0] - 1; i++) {
                    human_gene_sequence_promoter_string = human_gene_sequence_promoter_string + human_gene_sequence_all_charArray[i];
                    other_gene_sequence_promoter_string = other_gene_sequence_promoter_string + other_gene_sequence_all_charArray[i];
                }
            }
            //System.out.println(human_gene_sequence_promoter_string);

            human_gene_sequence_promoter_array = human_gene_sequence_promoter_string.toCharArray();
            other_gene_sequence_promoter_array = other_gene_sequence_promoter_string.toCharArray();

            for (int i = 0; i < human_gene_sequence_promoter_array.length; i++) {
                //calculating transitions
                if ((human_gene_sequence_promoter_array[i] == 'A' && other_gene_sequence_promoter_array[i] == 'G') || (human_gene_sequence_promoter_array[i] == 'G' && other_gene_sequence_promoter_array[i] == 'A') || (human_gene_sequence_promoter_array[i] == 'C' && other_gene_sequence_promoter_array[i] == 'T') || (human_gene_sequence_promoter_array[i] == 'T' && other_gene_sequence_promoter_array[i] == 'C')) {
                    promoters_transition++;
                }//end if

               /* //calculating transversions
                else if ((human_gene_sequence_promoter_array[i] == 'A' && other_gene_sequence_promoter_array[i] == 'C') || (human_gene_sequence_promoter_array[i] == 'A' && other_gene_sequence_promoter_array[i] == 'T') || (human_gene_sequence_promoter_array[i] == 'C' && other_gene_sequence_promoter_array[i] == 'A') || (human_gene_sequence_promoter_array[i] == 'C' && other_gene_sequence_promoter_array[i] == 'G') || (human_gene_sequence_promoter_array[i] == 'T' && other_gene_sequence_promoter_array[i] == 'A') || (human_gene_sequence_promoter_array[i] == 'T' && other_gene_sequence_promoter_array[i] == 'G') || (human_gene_sequence_promoter_array[i] == 'G' && other_gene_sequence_promoter_array[i] == 'C') || (human_gene_sequence_promoter_array[i] == 'G' && other_gene_sequence_promoter_array[i] == 'T')) {
                    promoters_transversion++;
                }//end else if*/

                if (human_gene_sequence_promoter_array[i] == '-' || other_gene_sequence_promoter_array[i] == '-') {

                    if (i == human_gene_sequence_promoter_array.length - 1) {
                        promoter_gap++;
                    } else if (human_gene_sequence_promoter_array[i] == '-') {

                        promoter_gap++;
                        while ((i < human_gene_sequence_promoter_array.length - 1) && (human_gene_sequence_promoter_array[i + 1] == '-')) {

                            i++;
                        }
//
                    }//end if
                    else if (other_gene_sequence_promoter_array[i] == '-') {

                        promoter_gap++;
                        while ((i < other_gene_sequence_promoter_array.length - 1) && (other_gene_sequence_promoter_array[i + 1] == '-')) {

                            i++;
                        }
                    }//end if
                }//end if

                if (human_gene_sequence_promoter_array[i] == other_gene_sequence_promoter_array[i]) {
                    promoter_match++;

                }
                if (human_gene_sequence_promoter_array[i] != other_gene_sequence_promoter_array[i] && human_gene_sequence_promoter_array[i] != '-' && other_gene_sequence_promoter_array[i] != '-') {
                    promoter_mismatch++;
                }
            }
            //end of promoters

            //calculating exons
            if (human_gene_sequence_all_charArray.length > ex_End_Array_int[ex_End_Array_int.length - 1]) {
                for (int i = 0; i < ex_Start_Array_int.length; i++) {
                    for (int j = ex_Start_Array_int[i]; j <= ex_End_Array_int[i]; j++) {
                        //calculating transitions
                        if ((human_gene_sequence_all_charArray[j] == 'A' && other_gene_sequence_all_charArray[j] == 'G') || (human_gene_sequence_all_charArray[j] == 'G' && other_gene_sequence_all_charArray[j] == 'A') || (human_gene_sequence_all_charArray[j] == 'C' && other_gene_sequence_all_charArray[j] == 'T') || (human_gene_sequence_all_charArray[j] == 'T' && other_gene_sequence_all_charArray[j] == 'C')) {
                            ex_transition++;
                        }//end if

               /* //calculating transversions
                else if ((human_gene_sequence_promoter_array[i] == 'A' && other_gene_sequence_promoter_array[i] == 'C') || (human_gene_sequence_promoter_array[i] == 'A' && other_gene_sequence_promoter_array[i] == 'T') || (human_gene_sequence_promoter_array[i] == 'C' && other_gene_sequence_promoter_array[i] == 'A') || (human_gene_sequence_promoter_array[i] == 'C' && other_gene_sequence_promoter_array[i] == 'G') || (human_gene_sequence_promoter_array[i] == 'T' && other_gene_sequence_promoter_array[i] == 'A') || (human_gene_sequence_promoter_array[i] == 'T' && other_gene_sequence_promoter_array[i] == 'G') || (human_gene_sequence_promoter_array[i] == 'G' && other_gene_sequence_promoter_array[i] == 'C') || (human_gene_sequence_promoter_array[i] == 'G' && other_gene_sequence_promoter_array[i] == 'T')) {
                    promoters_transversion++;
                }//end else if*/

                        if (human_gene_sequence_all_charArray[j] == '-' || other_gene_sequence_all_charArray[j] == '-') {

                            if (j == human_gene_sequence_all_charArray.length - 1) {
                                ex_gap++;
                            } else if (human_gene_sequence_all_charArray[j] == '-') {

                                ex_gap++;
                                while ((j < human_gene_sequence_all_charArray.length - 1) && (human_gene_sequence_all_charArray[j + 1] == '-')) {

                                    j++;
                                }
                            }//end if
                            else if (other_gene_sequence_all_charArray[j] == '-') {

                                ex_gap++;
                                while ((j < other_gene_sequence_all_charArray.length - 1) && (other_gene_sequence_all_charArray[j + 1] == '-')) {

                                    j++;
                                }
                            }//end if
                        }//end if

                        if (human_gene_sequence_all_charArray[j] == other_gene_sequence_all_charArray[j]) {
                            ex_match++;

                        }
                        if (human_gene_sequence_all_charArray[j] != other_gene_sequence_all_charArray[j] && human_gene_sequence_all_charArray[j] != '-' && other_gene_sequence_all_charArray[j] != '-') {
                            ex_mismatch++;
                        }
                    }
                }
            }
            //end of ex


            //5 UTR
            if (human_gene_sequence_all_charArray.length > tx_Start)
                for (int i = tx_Start; i <= cds_Start; i++) {
                    //calculating transitions
                    if ((human_gene_sequence_all_charArray[i] == 'A' && other_gene_sequence_all_charArray[i] == 'G') || (human_gene_sequence_all_charArray[i] == 'G' && other_gene_sequence_all_charArray[i] == 'A') || (human_gene_sequence_all_charArray[i] == 'C' && other_gene_sequence_all_charArray[i] == 'T') || (human_gene_sequence_all_charArray[i] == 'T' && other_gene_sequence_all_charArray[i] == 'C')) {
                        f_UTR_transition++;
                    }//end if

               /* //calculating transversions
                else if ((human_gene_sequence_promoter_array[i] == 'A' && other_gene_sequence_promoter_array[i] == 'C') || (human_gene_sequence_promoter_array[i] == 'A' && other_gene_sequence_promoter_array[i] == 'T') || (human_gene_sequence_promoter_array[i] == 'C' && other_gene_sequence_promoter_array[i] == 'A') || (human_gene_sequence_promoter_array[i] == 'C' && other_gene_sequence_promoter_array[i] == 'G') || (human_gene_sequence_promoter_array[i] == 'T' && other_gene_sequence_promoter_array[i] == 'A') || (human_gene_sequence_promoter_array[i] == 'T' && other_gene_sequence_promoter_array[i] == 'G') || (human_gene_sequence_promoter_array[i] == 'G' && other_gene_sequence_promoter_array[i] == 'C') || (human_gene_sequence_promoter_array[i] == 'G' && other_gene_sequence_promoter_array[i] == 'T')) {
                    promoters_transversion++;
                }//end else if*/

                    if (human_gene_sequence_all_charArray[i] == '-' || other_gene_sequence_all_charArray[i] == '-') {

                        if (i == human_gene_sequence_all_charArray.length - 1) {
                            f_UTR_gap++;
                        } else if (human_gene_sequence_all_charArray[i] == '-') {

                            f_UTR_gap++;
                            while ((i < human_gene_sequence_all_charArray.length - 1) && (human_gene_sequence_all_charArray[i + 1] == '-')) {

                                i++;
                            }
                        }//end if
                        else if (other_gene_sequence_all_charArray[i] == '-') {

                            f_UTR_gap++;
                            while ((i < other_gene_sequence_all_charArray.length - 1) && (other_gene_sequence_all_charArray[i + 1] == '-')) {

                                i++;
                            }
                        }//end if
                    }//end if

                    if (human_gene_sequence_all_charArray[i] == other_gene_sequence_all_charArray[i]) {
                        f_UTR_match++;

                    }
                    if (human_gene_sequence_all_charArray[i] != other_gene_sequence_all_charArray[i] && human_gene_sequence_all_charArray[i] != '-' && other_gene_sequence_all_charArray[i] != '-') {
                        f_UTR_mismatch++;
                    }
                }//end of 5 UTR

            //3 UTR
            if (human_gene_sequence_all_charArray.length > cds_End) {
                for (int i = cds_End; i <= tx_End; i++) {
                    //calculating transitions
                    if ((human_gene_sequence_all_charArray[i] == 'A' && other_gene_sequence_all_charArray[i] == 'G') || (human_gene_sequence_all_charArray[i] == 'G' && other_gene_sequence_all_charArray[i] == 'A') || (human_gene_sequence_all_charArray[i] == 'C' && other_gene_sequence_all_charArray[i] == 'T') || (human_gene_sequence_all_charArray[i] == 'T' && other_gene_sequence_all_charArray[i] == 'C')) {
                        t_UTR_transition++;
                    }//end if

               /* //calculating transversions
                else if ((human_gene_sequence_promoter_array[i] == 'A' && other_gene_sequence_promoter_array[i] == 'C') || (human_gene_sequence_promoter_array[i] == 'A' && other_gene_sequence_promoter_array[i] == 'T') || (human_gene_sequence_promoter_array[i] == 'C' && other_gene_sequence_promoter_array[i] == 'A') || (human_gene_sequence_promoter_array[i] == 'C' && other_gene_sequence_promoter_array[i] == 'G') || (human_gene_sequence_promoter_array[i] == 'T' && other_gene_sequence_promoter_array[i] == 'A') || (human_gene_sequence_promoter_array[i] == 'T' && other_gene_sequence_promoter_array[i] == 'G') || (human_gene_sequence_promoter_array[i] == 'G' && other_gene_sequence_promoter_array[i] == 'C') || (human_gene_sequence_promoter_array[i] == 'G' && other_gene_sequence_promoter_array[i] == 'T')) {
                    promoters_transversion++;
                }//end else if*/

                    if (human_gene_sequence_all_charArray[i] == '-' || other_gene_sequence_all_charArray[i] == '-') {

                        if (i == human_gene_sequence_all_charArray.length - 1) {
                            t_UTR_gap++;
                        } else if (human_gene_sequence_all_charArray[i] == '-') {

                            t_UTR_gap++;
                            while ((i < human_gene_sequence_all_charArray.length - 1) && (human_gene_sequence_all_charArray[i + 1] == '-')) {

                                i++;
                            }
                        }//end if
                        else if (other_gene_sequence_all_charArray[i] == '-') {

                            t_UTR_gap++;
                            while ((i < other_gene_sequence_all_charArray.length - 1) && (other_gene_sequence_all_charArray[i + 1] == '-')) {

                                i++;
                            }
                        }//end if
                    }//end if

                    if (human_gene_sequence_all_charArray[i] == other_gene_sequence_all_charArray[i]) {
                        t_UTR_match++;

                    }
                    if (human_gene_sequence_all_charArray[i] != other_gene_sequence_all_charArray[i] && human_gene_sequence_all_charArray[i] != '-' && other_gene_sequence_all_charArray[i] != '-') {
                        t_UTR_mismatch++;
                    }
                }
            }//end 3 UTR

            //calculating introns
            if (human_gene_sequence_all_charArray.length > ex_End_Array_int[ex_End_Array_int.length - 1]) {
                for (int i = 0; i < ex_Start_Array_int.length - 1; i++) {
                    for (int j = ex_End_Array_int[i] + 1; j < ex_Start_Array_int[i + 1]; j++) {
                        //calculating transitions
                        if ((human_gene_sequence_all_charArray[j] == 'A' && other_gene_sequence_all_charArray[j] == 'G') || (human_gene_sequence_all_charArray[j] == 'G' && other_gene_sequence_all_charArray[j] == 'A') || (human_gene_sequence_all_charArray[j] == 'C' && other_gene_sequence_all_charArray[j] == 'T') || (human_gene_sequence_all_charArray[j] == 'T' && other_gene_sequence_all_charArray[j] == 'C')) {
                            intron_transition++;
                        }//end if

               /* //calculating transversions
                else if ((human_gene_sequence_promoter_array[i] == 'A' && other_gene_sequence_promoter_array[i] == 'C') || (human_gene_sequence_promoter_array[i] == 'A' && other_gene_sequence_promoter_array[i] == 'T') || (human_gene_sequence_promoter_array[i] == 'C' && other_gene_sequence_promoter_array[i] == 'A') || (human_gene_sequence_promoter_array[i] == 'C' && other_gene_sequence_promoter_array[i] == 'G') || (human_gene_sequence_promoter_array[i] == 'T' && other_gene_sequence_promoter_array[i] == 'A') || (human_gene_sequence_promoter_array[i] == 'T' && other_gene_sequence_promoter_array[i] == 'G') || (human_gene_sequence_promoter_array[i] == 'G' && other_gene_sequence_promoter_array[i] == 'C') || (human_gene_sequence_promoter_array[i] == 'G' && other_gene_sequence_promoter_array[i] == 'T')) {
                    promoters_transversion++;
                }//end else if*/

                        if (human_gene_sequence_all_charArray[j] == '-' || other_gene_sequence_all_charArray[j] == '-') {

                            if (j == human_gene_sequence_all_charArray.length - 1) {
                                intron_gap++;
                            } else if (human_gene_sequence_all_charArray[j] == '-') {

                                intron_gap++;
                                while ((j < human_gene_sequence_all_charArray.length - 1) && (human_gene_sequence_all_charArray[j + 1] == '-')) {

                                    j++;
                                }
                            }//end if
                            else if (other_gene_sequence_all_charArray[j] == '-') {

                                intron_gap++;
                                while ((j < other_gene_sequence_all_charArray.length - 1) && (other_gene_sequence_all_charArray[j + 1] == '-')) {

                                    j++;
                                }
                            }//end if
                        }//end if

                        if (human_gene_sequence_all_charArray[j] == other_gene_sequence_all_charArray[j]) {
                            intron_match++;

                        }
                        if (human_gene_sequence_all_charArray[j] != other_gene_sequence_all_charArray[j] && human_gene_sequence_all_charArray[j] != '-' && other_gene_sequence_all_charArray[j] != '-') {
                            intron_mismatch++;
                        }
                    }
                }
            }

            //calculating intergenic
            intergenic_count++;
            if (intergenic_count == 1) {
                if (human_gene_sequence_all_charArray.length > ex_End_Array_int[0]){
                    for (int i = 0; i < ex_Start_Array_int[0]; i++) {
                        //calculating transitions
                        if ((human_gene_sequence_all_charArray[i] == 'A' && other_gene_sequence_all_charArray[i] == 'G') || (human_gene_sequence_all_charArray[i] == 'G' && other_gene_sequence_all_charArray[i] == 'A') || (human_gene_sequence_all_charArray[i] == 'C' && other_gene_sequence_all_charArray[i] == 'T') || (human_gene_sequence_all_charArray[i] == 'T' && other_gene_sequence_all_charArray[i] == 'C')) {
                            intergenic_transition++;
                        }//end if

               /* //calculating transversions
                else if ((human_gene_sequence_promoter_array[i] == 'A' && other_gene_sequence_promoter_array[i] == 'C') || (human_gene_sequence_promoter_array[i] == 'A' && other_gene_sequence_promoter_array[i] == 'T') || (human_gene_sequence_promoter_array[i] == 'C' && other_gene_sequence_promoter_array[i] == 'A') || (human_gene_sequence_promoter_array[i] == 'C' && other_gene_sequence_promoter_array[i] == 'G') || (human_gene_sequence_promoter_array[i] == 'T' && other_gene_sequence_promoter_array[i] == 'A') || (human_gene_sequence_promoter_array[i] == 'T' && other_gene_sequence_promoter_array[i] == 'G') || (human_gene_sequence_promoter_array[i] == 'G' && other_gene_sequence_promoter_array[i] == 'C') || (human_gene_sequence_promoter_array[i] == 'G' && other_gene_sequence_promoter_array[i] == 'T')) {
                    promoters_transversion++;
                }//end else if*/

                        if (human_gene_sequence_all_charArray[i] == '-' || other_gene_sequence_all_charArray[i] == '-') {

                            if (i == human_gene_sequence_all_charArray.length - 1) {
                                intergenic_gap++;
                            } else if (human_gene_sequence_all_charArray[i] == '-') {

                                intergenic_gap++;
                                while ((i < human_gene_sequence_all_charArray.length - 1) && (human_gene_sequence_all_charArray[i + 1] == '-')) {

                                    i++;
                                }
                            }//end if
                            else if (other_gene_sequence_all_charArray[i] == '-') {

                                intergenic_gap++;
                                while ((i < other_gene_sequence_all_charArray.length - 1) && (other_gene_sequence_all_charArray[i + 1] == '-')) {

                                    i++;
                                }
                            }//end if
                        }//end if

                        if (human_gene_sequence_all_charArray[i] == other_gene_sequence_all_charArray[i]) {
                            intergenic_match++;

                        }
                        if (human_gene_sequence_all_charArray[i] != other_gene_sequence_all_charArray[i] && human_gene_sequence_all_charArray[i] != '-' && other_gene_sequence_all_charArray[i] != '-') {
                            intergenic_mismatch++;
                        }
                    }
            }
        }
            else {
                if (human_gene_sequence_all_charArray.length > ex_End_Array_int[0]) {
                    for (int i = previous_ex_end + 1; i < ex_Start_Array_int[0]; i++) {
                        //calculating transitions
                        if ((human_gene_sequence_all_charArray[i] == 'A' && other_gene_sequence_all_charArray[i] == 'G') || (human_gene_sequence_all_charArray[i] == 'G' && other_gene_sequence_all_charArray[i] == 'A') || (human_gene_sequence_all_charArray[i] == 'C' && other_gene_sequence_all_charArray[i] == 'T') || (human_gene_sequence_all_charArray[i] == 'T' && other_gene_sequence_all_charArray[i] == 'C')) {
                            intergenic_transition++;
                        }//end if

               /* //calculating transversions
                else if ((human_gene_sequence_promoter_array[i] == 'A' && other_gene_sequence_promoter_array[i] == 'C') || (human_gene_sequence_promoter_array[i] == 'A' && other_gene_sequence_promoter_array[i] == 'T') || (human_gene_sequence_promoter_array[i] == 'C' && other_gene_sequence_promoter_array[i] == 'A') || (human_gene_sequence_promoter_array[i] == 'C' && other_gene_sequence_promoter_array[i] == 'G') || (human_gene_sequence_promoter_array[i] == 'T' && other_gene_sequence_promoter_array[i] == 'A') || (human_gene_sequence_promoter_array[i] == 'T' && other_gene_sequence_promoter_array[i] == 'G') || (human_gene_sequence_promoter_array[i] == 'G' && other_gene_sequence_promoter_array[i] == 'C') || (human_gene_sequence_promoter_array[i] == 'G' && other_gene_sequence_promoter_array[i] == 'T')) {
                    promoters_transversion++;
                }//end else if*/

                        if (human_gene_sequence_all_charArray[i] == '-' || other_gene_sequence_all_charArray[i] == '-') {

                            if (i == human_gene_sequence_all_charArray.length - 1) {
                                intergenic_gap++;
                            } else if (human_gene_sequence_all_charArray[i] == '-') {

                                intergenic_gap++;
                                while ((i < human_gene_sequence_all_charArray.length - 1) && (human_gene_sequence_all_charArray[i + 1] == '-')) {

                                    i++;
                                }
                            }//end if
                            else if (other_gene_sequence_all_charArray[i] == '-') {

                                intergenic_gap++;
                                while ((i < other_gene_sequence_all_charArray.length - 1) && (other_gene_sequence_all_charArray[i + 1] == '-')) {

                                    i++;
                                }
                            }//end if
                        }//end if

                        if (human_gene_sequence_all_charArray[i] == other_gene_sequence_all_charArray[i]) {
                            intergenic_match++;

                        }
                        if (human_gene_sequence_all_charArray[i] != other_gene_sequence_all_charArray[i] && human_gene_sequence_all_charArray[i] != '-' && other_gene_sequence_all_charArray[i] != '-') {
                            intergenic_mismatch++;
                        }
                    }
                }
            }
            previous_ex_end = ex_End_Array_int[ex_End_Array_int.length-1];

        }//end reading the other file

        System.out.println("Promoter match:" + promoter_match);
        System.out.println("Promoter mismatch" + promoter_mismatch);
        System.out.println("Promoter transition : "+promoters_transition);
        promoters_transversion = (promoter_mismatch-promoters_transition);
        System.out.println("Promoter transversion : "+promoters_transversion);
        System.out.println("Promoter gap : "+promoter_gap);
        promoter_gap_rate = promoter_gap/(promoter_mismatch+promoter_match+promoter_gap);
        System.out.println("Promoter Gap Rate : "+promoter_gap_rate);
        promoter_substitution_rate = promoter_mismatch/(promoter_mismatch+promoter_match);
        promoter_ratio = promoters_transition/promoters_transversion;
        System.out.println("Promoter Substitution Rate : "+promoter_substitution_rate);
        System.out.println("Promoter ratio : "+promoter_ratio );


        System.out.println("EX match:" + ex_match);
        System.out.println("EX mismatch" + ex_mismatch);
        System.out.println("EX transition : "+ex_transition);
        ex_transversion = ex_mismatch-ex_transition;
        System.out.println("EX transversion : "+ex_transversion);
        System.out.println("EX Gap : "+ex_gap);
        ex_gap_rate = ex_gap/(ex_mismatch+ex_match+ex_gap);
        System.out.println("Exon Gap Rate is :"+ex_gap_rate);
        ex_substitution_rate = ex_mismatch/(ex_mismatch+ex_match);
        ex_ratio = ex_transition/ex_transversion;
        System.out.println("Exon substitution : "+ex_substitution_rate);
        System.out.println("Exon Ratio : "+ex_ratio);


        System.out.println("5 UTR match:" + f_UTR_match);
        System.out.println("5 UTR mismatch" + f_UTR_mismatch);
        System.out.println("5 UTR transition" + f_UTR_transition);
        f_UTR_transversion = f_UTR_mismatch-f_UTR_transition;
        System.out.println("5 UTR transversion" + f_UTR_transversion);
        System.out.println("5 UTR Gap" + f_UTR_gap);
        f_UTR_gap_rate = f_UTR_gap/(f_UTR_mismatch+f_UTR_match+f_UTR_gap);
        System.out.println("5 UTR Gap Rate : "+f_UTR_gap_rate);
        f_UTR_substitution_rate = f_UTR_mismatch/(f_UTR_mismatch+f_UTR_match);
        f_UTR_ratio = f_UTR_transition/f_UTR_transversion;
        System.out.println("5 UTR Substitution rate : "+f_UTR_substitution_rate);
        System.out.println("5 UTR Ratio : "+f_UTR_ratio);

        System.out.println("3 UTR match:" + t_UTR_match);
        System.out.println("3 UTR mismatch" + t_UTR_mismatch);
        System.out.println("3 UTR transition" + t_UTR_transition);
        t_UTR_transversion = t_UTR_mismatch-t_UTR_transition;
        System.out.println("3 UTR transversion" + t_UTR_transversion);
        System.out.println("3 UTR Gap" + t_UTR_gap);
        t_UTR_gap_rate = t_UTR_gap/(t_UTR_mismatch+t_UTR_match+t_UTR_gap);
        System.out.println("3 UTR Gap Rate : "+t_UTR_gap_rate);
        t_UTR_substitution_rate = t_UTR_mismatch/(t_UTR_mismatch+t_UTR_match);
        t_UTR_ratio = t_UTR_transition/t_UTR_transversion;
        System.out.println("5 UTR Substitution rate : "+t_UTR_substitution_rate);
        System.out.println("5 UTR Ratio : "+t_UTR_ratio);

        System.out.println("Introns match: "+intron_match);
        System.out.println("Intron mismatch: "+intron_mismatch);
        System.out.println("Introns transition : "+intron_transition);
        intron_transversion = intron_mismatch-intron_transition;
        System.out.println("Intron transversion : "+intron_transversion);
        System.out.println("Intron Gap : "+intron_gap);
        intron_gap_rate = intron_gap/(intron_mismatch+intron_match+intron_gap);
        System.out.println("Intron Gap Rate : "+intron_gap_rate);
        intron_substitution_rate = intron_mismatch/(intron_mismatch+intron_match);
        intron_ratio = intron_transition/intron_transversion;
        System.out.println("Intron Substitution rate : "+intron_substitution_rate);
        System.out.println("Intron Ratio : "+intron_ratio);

        System.out.println("Intergenic match: "+intergenic_match);
        System.out.println("Intergenic mismatch: "+intergenic_mismatch);
        System.out.println("Intergenic transition:"+intergenic_transition);
        intergenic_transversion = intergenic_mismatch-intergenic_transition;
        System.out.println("Intergenic transversion : "+intergenic_transversion);
        System.out.println("Intergenic Gap : "+intergenic_gap);
        intergenic_gap_rate = intergenic_gap/(intergenic_mismatch+intergenic_match+intergenic_gap);
        System.out.println("Intergenic Gap Rate : "+intergenic_gap_rate);
        intergenic_substitution_rate = intergenic_mismatch/(intergenic_mismatch+intergenic_match);
        intergenic_ratio = intergenic_transition/intergenic_transversion;
        System.out.println("Intergenic Substitution rate : "+intergenic_substitution_rate);
        System.out.println("Intergenic Ratio : "+intergenic_ratio);

        System.out.println(seq);

        //System.out.println(lines_all_count);


      /*  Set< Map.Entry< Integer,Integer> > sti1 = promoter_indel_Map.entrySet();
        for (Map.Entry< Integer,Integer> me1:sti1)
        {
            System.out.print("Promoter Gap Count : "+me1.getKey()+":");
            System.out.println(me1.getValue()+"  The frequency is: " +(me1.getValue()/promoter_gap));
        }*/
    }//end main

}//end main class
