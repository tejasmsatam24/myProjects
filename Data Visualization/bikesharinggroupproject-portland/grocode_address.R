# Geocoding a csv column of "addresses" in R

#load ggmap

library(ggmap)
library(tidyverse)

setwd("/Users/vamsiyashwanth/Desktop/NIU COURCES/Spring 19")

# Select the file from the file chooser
#fileToLoad <- file.choose(new = TRUE)

# Read in the CSV data and store it in a variable 
#origAddress <- read.csv(fileToLoad, stringsAsFactors = FALSE)

origAddress <- read_csv("List_of_universities.csv")
origAddress


# Initialize the data frame
geocoded <- data.frame(stringsAsFactors = FALSE)



register_google(key="AIzaSyDKLZT7tM-My67l7oNZIuD8IUwXolu_NHE")

# Loop through the addresses to get the latitude and longitude of each address and add it to the
# origAddress data frame in new columns lat and lon
for(i in 1:nrow(origAddress))
{
  # Print("Working...")
  result <- geocode(origAddress$Address[i], output = "latlona", source = "google")
  origAddress$lon[i] <- as.numeric(result[1])
  origAddress$lat[i] <- as.numeric(result[2])
  origAddress$geoAddress[i] <- as.character(result[3])
}
# Write a CSV file containing origAddress to the working directory
write.csv(origAddress, "geocoded.csv", row.names=FALSE)