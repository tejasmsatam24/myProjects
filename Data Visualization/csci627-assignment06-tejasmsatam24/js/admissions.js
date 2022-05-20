var chart, x, y;
var margin = {top: 20, right: 20, bottom: 40, left: 60};
var height = 300-margin.top-margin.bottom;
var width = 500-margin.left-margin.right;
var path = "data/GradAdmissionsData.csv"
//DEFINE YOUR VARIABLES UP HERE

//Gets called when the page is loaded.
function init(){
	chart = d3.select('#vis').append('svg')
			.attr("width",width+margin.left+margin.right)
			.attr("height",height+margin.top+margin.bottom);
	vis = chart.append('g')
		 .attr("transform", "translate(" + margin.left + "," + margin.top + ")");
	
	// ADD ANY NECESSARY ATTRIBUTES TO SVG ELEMENT
	
	//PUT YOUR INIT CODE BELOW (IF NEEDED)
	
}

//Called when the update button is clicked
function updateClicked(){
	d3.csv('data/GradAdmissionsData.csv').then(function(data){update(data)});
}

//Callback for when data is loaded
function update(rawdata){
	//PUT YOUR UPDATE CODE TO CREATE OR UPDATE VISUALIZATION BELOW
		
		console.log(rawdata)
		if(getXAttribute() == "GRE Score" && getYAttribute() =="Chance of Admit"){
			
				//To refresh the page, the function remove() will remove the svg and we will again create the svg
				d3.select("svg").remove();
				chart = d3.select('#vis').append('svg')
						.attr("width",width+margin.left+margin.right)
						.attr("height",height+margin.top+margin.bottom);
						vis = chart.append('g')
						.attr("transform", "translate(" + margin.left + "," + margin.top + ")");
				var groupGRE = d3.nest()
				.key(function (d) { return d.GRE_Score; })
				.rollup(function (v) { return d3.mean(v, function (d) { return d.Chance_of_Admit; }); })
				.entries(rawdata);
				console.log(groupGRE)

				var x = d3.scaleBand()
					.domain(groupGRE.map(function (key, value) { return key.key; }))
					.range([0, width])
					.padding(0.1);
					maxy = d3.max(groupGRE).value
					var y = d3.scaleLinear()
					.domain([0, maxy])
					.range([height, 0])
			// Define bars
				vis.selectAll("rect").data(groupGRE)
					.enter().append("rect")
					.attr("x", function (d,i) { console.log(groupGRE.key); return (width/5)*i; })
					.attr("y", function (t5) { return y(t5.value); })
					.attr("width", x.bandwidth())
					.attr("height", function (groupGRE) { return height - y(groupGRE.value); })
			// Define axes
				vis.append("g")
					.call(d3.axisLeft(y).tickPadding(10).tickSize(10));
				vis.append("g")
					.attr("transform", "translate(0," + height + ")")
					.call(d3.axisBottom(x).tickPadding(10).tickSize(10));
				vis.append("text")
						 .attr("transform","translate(" + (width/2) + " ," + (height + margin.top + 20) + ")")
						 .style("text-anchor", "middle")
						 .text(getXAttribute());

					
				 vis.append("text")
			   		.attr("transform", "rotate(-90)")
			   		.attr("y", 0 - margin.left)
			   		.attr("x",0 - (height / 2))
			   		.attr("dy", "1em")
			   		.style("text-anchor", "middle")
			   		.text(getYAttribute());
				}

			else if((getXAttribute() == "GRE Score") && (getYAttribute()=="Student Count"))
			{
				d3.select("svg").remove();
				chart = d3.select('#vis').append('svg')
						.attr("width",width+margin.left+margin.right)
						.attr("height",height+margin.top+margin.bottom);
				vis = chart.append('g')
				.attr("transform", "translate(" + margin.left + "," + margin.top + ")");
				var groupGREtwo = d3.nest()
				.key(function (d) { return d.GRE_Score; })
				.rollup(function (v) { return v.length; })
				.entries(rawdata);
				console.log(groupGREtwo)

				var x = d3.scaleBand()
				.domain(groupGREtwo.map(function (key, value) { return key.key; }))
				.range([0, width])
				.padding(0.1);
				maxy = d3.max(groupGREtwo).value
				var y = d3.scaleLinear()
				.domain([0, maxy])
				.range([height, 0])
				// Define bars
				vis.selectAll("rect").data(groupGREtwo)
				.enter().append("rect")
				.attr("x", function (d,i) {return (width/5)*i; })
				.attr("y", function (t5) { return y(t5.value); })
				.attr("width", x.bandwidth())
				.attr("height", function (groupGREtwo) { return height - y(groupGREtwo.value); })
				// Define axes
				vis.append("g")
				.call(d3.axisLeft(y).tickPadding(10).tickSize(10));
				vis.append("g")
				.attr("transform", "translate(0," + height + ")")
				.call(d3.axisBottom(x).tickPadding(10).tickSize(10));
				vis.append("text")
						 .attr("transform","translate(" + (width/2) + " ," + (height + margin.top + 20) + ")")
						 .style("text-anchor", "middle")
						 .text(getXAttribute());

					
				 vis.append("text")
			   		.attr("transform", "rotate(-90)")
			   		.attr("y", 0 - margin.left)
			   		.attr("x",0 - (height / 2))
			   		.attr("dy", "1em")
			   		.style("text-anchor", "middle")
			   		.text(getYAttribute());
			}
			else if((getXAttribute() == "Research") && (getYAttribute()=="Chance of Admit"))
			{
				d3.select("svg").remove();
				chart = d3.select('#vis').append('svg')
						.attr("width",width+margin.left+margin.right)
						.attr("height",height+margin.top+margin.bottom);
						vis = chart.append('g')
						.attr("transform", "translate(" + margin.left + "," + margin.top + ")");
				var groupRes = d3.nest()
				.key(function (d) { return d.Research; })
				.rollup(function (v) { return d3.mean(v, function (d) { return d.Chance_of_Admit; }); })
				.entries(rawdata);
				console.log(groupRes)
				var x = d3.scaleBand()
				.domain(groupRes.map(function (key, value) { return key.key; }))
				.range([0, width])
				.padding(0.1);
				maxy = d3.max(groupRes).value
				var y = d3.scaleLinear()
				.domain([0, maxy])
				.range([height, 0])
				// Define bars
				vis.selectAll("rect").data(groupRes)
				.enter().append("rect")
				.attr("x", function (d,i) {return (width/2)*i; })
				.attr("y", function (t5) { return y(t5.value); })
				.attr("width", x.bandwidth())
				.attr("height", function (groupRes) { return height - y(groupRes.value); })
				// Define axes
				vis.append("g")
				.call(d3.axisLeft(y).tickPadding(10).tickSize(10));
				vis.append("g")
				.attr("transform", "translate(0," + height + ")")
				.call(d3.axisBottom(x).tickPadding(10).tickSize(10));
				vis.append("text")
						 .attr("transform","translate(" + (width/2) + " ," + (height + margin.top + 20) + ")")
						 .style("text-anchor", "middle")
						 .text(getXAttribute());

					
				 vis.append("text")
			   		.attr("transform", "rotate(-90)")
			   		.attr("y", 0 - margin.left)
			   		.attr("x",0 - (height / 2))
			   		.attr("dy", "1em")
			   		.style("text-anchor", "middle")
			   		.text(getYAttribute());
				}

				else if((getXAttribute() == "Research") && (getYAttribute()=="Student Count"))
				{
					d3.select("svg").remove();
					chart = d3.select('#vis').append('svg')
						.attr("width",width+margin.left+margin.right)
						.attr("height",height+margin.top+margin.bottom);
					vis = chart.append('g')
					.attr("transform", "translate(" + margin.left + "," + margin.top + ")");
					var groupRestwo = d3.nest()
					.key(function (d) { return d.Research; })
					.rollup(function (v) { return v.length; })
					.entries(rawdata);
					console.log(groupRestwo)
					var x = d3.scaleBand()
					.domain(groupRestwo.map(function (key, value) { return key.key; }))
					.range([0, width])
					.padding(0.1);
					maxy = d3.max(groupRestwo).value
					var y = d3.scaleLinear()
					.domain([0, maxy])
					.range([height, 0])
					// Define bars
					vis.selectAll("rect").data(groupRestwo)
					.enter().append("rect")
					.attr("x", function (d,i) {return (width/2)*i; })
					.attr("y", function (t5) { return y(t5.value); })
					.attr("width", x.bandwidth())
					.attr("height", function (groupRestwo) { return height - y(groupRestwo.value); })
					// Define axes
					vis.append("g")
					.call(d3.axisLeft(y).tickPadding(10).tickSize(10));
					vis.append("g")
					.attr("transform", "translate(0," + height + ")")
					.call(d3.axisBottom(x).tickPadding(10).tickSize(10));
					vis.append("text")
						 .attr("transform","translate(" + (width/2) + " ," + (height + margin.top + 20) + ")")
						 .style("text-anchor", "middle")
						 .text(getXAttribute());

					
				 vis.append("text")
			   		.attr("transform", "rotate(-90)")
			   		.attr("y", 0 - margin.left)
			   		.attr("x",0 - (height / 2))
			   		.attr("dy", "1em")
			   		.style("text-anchor", "middle")
			   		.text(getYAttribute());
				}


				else if((getXAttribute() == "SOP") && (getYAttribute()=="Chance of Admit"))
				{
					d3.select("svg").remove();
					chart = d3.select('#vis').append('svg')
						.attr("width",width+margin.left+margin.right)
						.attr("height",height+margin.top+margin.bottom);
					vis = chart.append('g')
					.attr("transform", "translate(" + margin.left + "," + margin.top + ")");
					var groupSop = d3.nest()
					.key(function (d) { return d.SOP; })
					.rollup(function (v) { return d3.mean(v, function (d) { return d.Chance_of_Admit; }); })
					.entries(rawdata);
					console.log(groupSop)
					var x = d3.scaleBand()
					.domain(groupSop.map(function (key, value) { return key.key; }))
					.range([0, width])
					.padding(0.1);
					maxy = d3.max(groupSop).value
					var y = d3.scaleLinear()
					.domain([0, maxy])
					.range([height, 0])
					// Define bars
					vis.selectAll("rect").data(groupSop)
					.enter().append("rect")
					.attr("x", function (d,i) {return (width/4)*i; })
					.attr("y", function (t5) { return y(t5.value); })
					.attr("width", x.bandwidth())
					.attr("height", function (groupSop) { return height - y(groupSop.value); })
					// Define axes
					vis.append("g")
					.call(d3.axisLeft(y).tickPadding(10).tickSize(10));
					vis.append("g")
					.attr("transform", "translate(0," + height + ")")
					.call(d3.axisBottom(x).tickPadding(10).tickSize(10));
					vis.append("text")
						 .attr("transform","translate(" + (width/2) + " ," + (height + margin.top + 20) + ")")
						 .style("text-anchor", "middle")
						 .text(getXAttribute());

					
				 vis.append("text")
			   		.attr("transform", "rotate(-90)")
			   		.attr("y", 0 - margin.left)
			   		.attr("x",0 - (height / 2))
			   		.attr("dy", "1em")
			   		.style("text-anchor", "middle")
			   		.text(getYAttribute());
					}

					else if((getXAttribute() == "SOP") && (getYAttribute()=="Student Count"))
					{
						d3.select("svg").remove();
						chart = d3.select('#vis').append('svg')
						.attr("width",width+margin.left+margin.right)
						.attr("height",height+margin.top+margin.bottom);
						vis = chart.append('g')
						.attr("transform", "translate(" + margin.left + "," + margin.top + ")");
						var groupSoptwo = d3.nest()
						.key(function (d) { return d.SOP; })
						.rollup(function (v) { return v.length; })
						.entries(rawdata);
						console.log(groupSoptwo)
						var x = d3.scaleBand()
						.domain(groupSoptwo.map(function (key, value) { return key.key; }))
						.range([0, width])
						.padding(0.1);
						maxy = d3.max(groupSoptwo).value
						var y = d3.scaleLinear()
						.domain([0, maxy])
						.range([height, 0])
						// Define bars
						vis.selectAll("rect").data(groupSoptwo)
						.enter().append("rect")
						.attr("x", function (d,i) {return (width/4)*i; })
						.attr("y", function (t5) { return y(t5.value); })
						.attr("width", x.bandwidth())
						.attr("height", function (groupSoptwo) { return height - y(groupSoptwo.value); })
						// Define axes
						vis.append("g")
						.call(d3.axisLeft(y).tickPadding(10).tickSize(10));
						vis.append("g")
						.attr("transform", "translate(0," + height + ")")
						.call(d3.axisBottom(x).tickPadding(10).tickSize(10));
						vis.append("text")
						 .attr("transform","translate(" + (width/2) + " ," + (height + margin.top + 20) + ")")
						 .style("text-anchor", "middle")
						 .text(getXAttribute());

					
				 vis.append("text")
			   		.attr("transform", "rotate(-90)")
			   		.attr("y", 0 - margin.left)
			   		.attr("x",0 - (height / 2))
			   		.attr("dy", "1em")
			   		.style("text-anchor", "middle")
			   		.text(getYAttribute());
					}
}

// Returns the selected option in the X-axis dropdown.
function getXAttribute(){
	var node = d3.select('#attr_X').node();
	return node[node.selectedIndex].getAttribute('val');
}

// Returns the selected option in the X-axis dropdown. 
function getYAttribute(){
	var node = d3.select('#attr_Y').node();
	return node[node.selectedIndex].getAttribute('val');
}
