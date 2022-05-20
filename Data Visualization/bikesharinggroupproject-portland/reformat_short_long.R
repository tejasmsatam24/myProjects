library(tidyverse)
library(hms)

bike <- read_csv("Desktop/NIU COURCES/Spring 19/project data/combined_data.csv",col_types = list(col_integer(),
                                                                                                 col_character(),
                                                                                                 col_character(),
                                                                                                 col_double(),
                                                                                                 col_double(),
                                                                                                 col_character(),#col_date("%m/%d/%y"),
                                                                                                 col_time(),
                                                                                                 col_character(),
                                                                                                 col_double(),
                                                                                                 col_double(),
                                                                                                 col_character(),#col_date("%m/%d/%y"),
                                                                                                 col_time(),
                                                                                                 col_character(),
                                                                                                 col_integer(),
                                                                                                 col_character(),
                                                                                                 col_double(),
                                                                                                 col_character(),#col_time(),
                                                                                                 col_character(),
                                                                                                 col_logical()
                                                                                                 ))


bike$End_Date <- as.Date(as.character(bike$End_Date), format="%m/%d/%Y")
bike$Start_Date <- as.Date(as.character(bike$Start_Date), format="%m/%d/%Y")
bike$Duration <- as.hms(bike$Duration)

bike

bike.long<-NULL
bike.long <- gather(bike, Type_LatLong, Location_value, c("Start_Latitude", "Start_Longitude","End_Latitude", "End_Longitude"))
bike.long

unique(bike.long$Type_LatLong)


bike.long <- separate(bike.long, Type_LatLong, c("Type","LatLong"), sep = '_')
bike.long

#bike.long %>% mutate(i = Route_ID)  %>% spread(LatLong, Location_value)
#bike.long <- spread(bike.long, LatLong, Location_value)

bike.long <-bike.long %>% 
  group_by_at(vars(-Route_ID,-Payment_Plan,-Start_Hub,-Start_Date,-Start_Time,-End_Hub,-End_Date,-End_Time,-Trip_Type,-Bike_ID,-Bike_Name,-Distance_Miles,-Duration,-Rental_AccessPath,-Multiple_Rental,-Type,-LatLong )) %>%  # group by everything other than the value column. 
  mutate(row_id=1:n()) %>% ungroup() %>%  # build group index
  spread(key=LatLong, value=Location_value) %>%    # spread
  select(-row_id)  # drop the index

bike.long
summary(bike.long)

path <- "Desktop/NIU COURCES/Spring 19/project data/"
write_csv(bike.long, file.path("Desktop/NIU COURCES/Spring 19/project data/combined_data.long.csv"))

 #bike.long <- gather(bike, Type_LatLong, Location_value, c("Start_Latitude", "Start_Longitude","End_Latitude", "End_Longitude"))
#bike.long


unique(bike$Bike_Name)

summary(bike)

bike$Start_Hub = "Out of Station"

bike$Start_Hub
          
grep("Out", bike) 

bike[0]
