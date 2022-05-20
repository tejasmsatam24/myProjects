# CSCI627 Assignment06 - D3.js
In this assignment you will start with the github classroom link, accept the invite which will create your own assignment repository, clone it to your computer, modify the given code template by adding D3 and other javascript code, commit the changes, and push back the updated repository to github.

## Potential Resources:
- Lynda.com
    - D3.js Essential Training for Data Scientists
    - Learning Data Visualization with D3.js
- [D3: Data-Driven Documents](https://d3js.org)
- https://bl.ocks.org/mbostock

There are many tutorials and examples, as well as numerous books on using and developing with javascript and D3.js.
    
## Learning Outcomes
- Experience with D3 and javascript for visualization
- Create interactive visualization - specifically a barchart in this assignment
- Transform raw data using D3 and javascript
- Organize code by adding pieces at specific places in a given code template

## Directions
1. Accept GitHub Classroom Assignment via link provided on slack.
2. On a local resource clone the newly created repository.
3. Open *index.html* to make sure the template works fine. You should be able to see two dropdown menus with loaded attributes and a update button.
4. Open *js/admissions.js* file. Brief comments were added to help you understand what code is expected. The goal is to produce a visualization (bar chart) using the selected columns in the drop down menus.
5. As the visualization needs data from an external dataset, you can run a simple http server module in python on a specific port to access dataset from *data/GradAdmissionsData.csv*.
    - You may do this locally on your own machine or via hartley.cs.niu.edu 
    - Activate your environment python environment using conda
    - Open a terminal and navigate to location of the index.html (either locally or on hartley)
    - Run the command: python -m http.server <your_assigned_port>
    - Open another terminal and do port forwarding (if you are using hartley):
    	`ssh -l <your_username> -L <your_assigned_port>:localhost:<your_assigned_port> hartley.cs.niu.edu`
    - Open a web browser and go to localhost:<your_assigned_port>. This will show the main html page. Whenever any changes are made, refresh the page to verify the changes in the visualization.
6. The attributes added in the X-axis drop down are available directly from the dataset. But the attributes loaded in the Y-axis dropdown need to be *computed on the fly based on the selection*. For example, selection in X dropdown is 'GRE Score' then compute following based on Y dropdown selection
    - Average chance of admit: Compute average for each GRE Score bin in the dataset.
    - Number of students: Compute number of students in each GRE Score bin in the dataset.
    __Hint: Read about D3.nest() to perform group by and calculate summary stats.__
7. Using the bins in the x-axis attribute and values in the Y-axis attribute produce a bar chart.
8. Every time when selection changes in any drop down, clicking on Update button should update the visualization.
9. Also, the visualization should have axis, ticks and labels added using D3 axis methods.
10. Commit changes to repository, remember to add a useful commit message.
11. Push committed changes to github.
