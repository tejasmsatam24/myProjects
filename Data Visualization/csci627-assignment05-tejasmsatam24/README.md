# CSCI627 Assignment05 - Tableau
In this assignment you will start with the github classroom link, create your own assignment repository, clone it to your computer, create two new tableau sessions, commit the changes, and push back the updated repository to github.

## Potential Resources:

- Lynda.com
	- Tableau Essential Training
	- Tableau 10 Essential Training
	- Tableau 10 for Data Scientists
	- Integrating Tableau and R for Data Science

- Tableau.com
	- Training (https://www.tableau.com/learn)
	- Forums and Community (https://community.tableau.com/welcome)
	
## Learning Outcomes
- Experience with tableau and using it for data visualization.
- Produce the following visualizations
	- Scatterplot
	- Barchart
	- Histogram
- Manipulate data within Tableau
- Create a map visualization using Tableau

## Directions (You cannot use hartley for this assignment!)
1. Accept github classroom assignment via link provided in email or on slack.
2. Install tableau on your laptop or desktop system.
3. Start a new file in tableau.
4. Open the mtcars dataset in the `Data` directory within your cloned GitHub directory. (it is a CSV file *Connect To a Text file*)
5. Rename the following fields in dataset:

|Dataset Name|New Name|
|---|---|
| Model | Cars |
| mpg | MPG |
| cyl | #Cylinders |
| disp | Displacement |
| hp | Horsepower |
| drat | RearAxleRatio |
| wt | Weight |
| qsec | QuarterMile |
| vs | CylinderConfiguration |
| am | TransmissionType |
| carb | Carburetors |

6. Split the Cars column, this will create two new columns, rename them *Make* and *Model* respectively.
7. Create a **scatterplot** of *MPG* versus *Horsepower*, where the color encodes the *#Cylinders* use filled circles for the shape. Appropriately title and label your scatterplot, don't forget your legend.
8. Create a second worksheet that is a **barchart** that shows the *MPG* for each *model*, color the bars by *make* and order them from lowest *MPG* to highest *MPG*, group them by *make*. Appropriately title and label your barchart.
9. Create a third worksheet and then create a **histogram** of *MPG* for the MTCARS dataset, color the histogram by *make*, make the bin size 1 MPG.
10. Save the tableau session as **mtcars** into your repository.
11. Open a new tableau session and read in the *nodes.csv* file from the repositories `Data` directory. (it is a CSV file *Connect To a Text file*)
12. You do not need to modify the data in anyway, plot the Lat and Lon of the data as a map, color the map by Description. Create a title for the map that is "<the number of distinct node types> Types of AoT Nodes in Chicago".
13. Save the tableau session as **aot** into your repository.
14. Commit changes to repository, remember to add the two tableau files and useful commit message.
15. Push committed changes to github.
