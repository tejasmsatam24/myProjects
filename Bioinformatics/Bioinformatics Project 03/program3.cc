#include<iostream>
#include<fstream>
#include <bits/stdc++.h>
#include<string>
#include <list>

using namespace std; 


float T[200000];
int tTotal = 0;
int correct = 0;
int cTotal = 0;
int criteria = 5; //default value is 5


bool isBase(char c)
{
  bool flag = false;
	switch(c)
	{
  	case 'A':
  	case 'C':
  	case 'G':
  	case 'T':flag = true;
             break;
  }
  return flag;
}

void processTrueAlignment(string x, string y) {

  tTotal = 0;
  int len = x.length();
  int n = y.length();
	if (n < len)
	{
    		len = n;
  }

  int pos1 = 0;
  int pos2 = 0;
  for (int i =0; i < len; i++)
	{
    char c1 = toupper(x[i]);
    char c2 = toupper(y[i]);
    if (isBase(c1)) {
      if (isBase(c2)) {
        T[pos1] = pos2;
      } else {
        T[pos1] = pos2 - 0.5;
      }
      pos1++;
    }
    if (isBase(c2)) {
      pos2++;
    }
  }
  tTotal = pos1;
}

void processComputedAlignment(int pos1, int pos2, string x, string y) {
  int len = x.length();
  int n = y.length();
	if (n < len)
	{
    len = n;
  }

  for (int i =0; i < len; i++)
	{
    if (pos1 >= tTotal) {
        break;
    }

    char c1 = toupper(x[i]);
    char c2 = toupper(y[i]);
    float computedPosition = 0;
    if (isBase(c1)) {
      int truePosition = T[pos1];
      if (isBase(c2)) {
        computedPosition =  pos2;
      } else {
        computedPosition =  pos2 - 0.5;
      }
      float diff = abs(truePosition - computedPosition);
      if (diff <= criteria) {
        correct++;
      }
      pos1++;
      cTotal++;
    }
    if (isBase(c2)) {
      pos2++;
    }
  }
}

const vector<string> explode(const string& s, const char& c)
{
	string buff = "";
	vector<string> v;
  int len = s.length();

  for (int i =0; i < len; i++)
	{
    char n = s[i];
		if(n != c) buff+=n; else
		if(n == c && buff != "") { v.push_back(buff); buff = ""; }
	}
	if(buff != "") v.push_back(buff);

	return v;
}

const vector<int> parseList(const string& s, const char& c)
{
	string buff = "";
	vector<int> v;
  int len = s.length();

  for (int i =0; i < len; i++)
	{
    char n = s[i];
		if(n != c) buff+=n; else
		if(n == c && buff != "") { v.push_back(atoi(buff.c_str()));
    buff = ""; }
	}
	if(buff != "") v.push_back(atoi(buff.c_str()));

	return v;
}

void processTrueAlignmentFile(string filename) {

  cout << "Reading True Alignment File " << filename <<  endl;
   ifstream in(filename, ios::in);

   if (!in.is_open()) {
     cerr << "Error: Unable to open file \"" << filename << "\" for reading!" << endl;
     exit(-1);
   }


  cout << "opened file successfully \n";
  int lineCount = 0;
  string alignmentttext[2];
  int alignCount = 0;
  string line;

  while (getline(in, line)) {
    lineCount++;
    if (line.length() == 0) {
      continue;
    }
    char c = line[0];
    if (c == '>') {
      continue;
    }
    alignmentttext[alignCount++] = line;
    if (alignCount >= 2) {
      break;
    }
  }

  if (alignCount < 2) {
     cerr << "Error: Did not find two aligned gene sequences in input file" << endl;
     exit(-1);
   }
  in.close();

  processTrueAlignment(alignmentttext[0], alignmentttext[1]);

}

void processComputedAlignmentFile(string filename) {
  cout << "processing computed file " << filename << endl;

  cTotal = 0;
  correct = 0;

  ifstream in(filename, ios::in);
  if (!in.is_open()) {
   	cerr << "Error: Unable to open file \"" << filename << "\" for reading!" << endl;
   	exit(-1);
  }
  cout << "opened file successfully \n";

  int lineCount = 0;
  string line;
  int pos[2];
  string text[2];
  int count = 0;

  while (getline(in, line)) {
    char c = line[0];
  	lineCount++;

    // Comment this if you need to process entire file
    if (lineCount > 100) {
      break;
    }

    if (c == 's') {
      vector<string> v  = explode(line, ' ');
      pos[count]=atoi(v[2].data());
      text[count]=v.back();
      count++;
    }
    if (count == 2) {
      // process
      /* cout << pos[0] << endl;
        cout << text[0] << endl;
        cout << pos[1] << endl;
        cout << text[1] << endl;
      */
      processComputedAlignment(pos[0], pos[1], text[0], text[1]);
      count = 0;
    }
  }
}


int main(int argc, char *argv[]) {

  string truefilename = "true.txt";
  string computedfilename = "computed.txt";
  if (argc > 1) {
     truefilename = argv[1];
  }
  if (argc > 2) {
    computedfilename = argv[2];
  }

  if (argc > 3) {
    criteria = atoi(argv[3]);
  }
  processTrueAlignmentFile(truefilename);
  cout << "processTrueAlignmentFile complete" << endl;
  processComputedAlignmentFile(computedfilename);

  float sensitivity = 0;
  float specificity = 0;
  if (tTotal > 0) {
    sensitivity = (float)correct / tTotal;
  }

  if (cTotal > 0) {
      specificity = (float) correct / cTotal;
  }
 // cout << "criteria=" << criteria << endl;
 // cout << "True Match Count=" << tTotal << endl;
//  cout << "Computed Match Count=" << cTotal << endl;
//  cout << "Computed Correct Match=" << correct << endl;
//  cout << "sensitivity=" << sensitivity << endl;
//  cout << "specificity=" << specificity << endl;
   cout <<"Criteria \t  True Match Count \t Computed Match Count \t Computed Correct Match \t Sensitivity \t Specificity \n";
  cout << criteria << "\t \t \t" << tTotal << "\t \t \t " << cTotal << "\t \t \t" << correct << "\t \t \t" << sensitivity <<"\t \t" << specificity << endl;
}
