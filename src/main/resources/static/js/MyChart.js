var niceChartStr = decodeHtml(chartData);
var chartJsonArray = JSON.parse(niceChartStr);

var arrayLength = chartJsonArray.length;
var numericData =[];
var labelData = [];

for( var i = 0;i< arrayLength;i++){
	numericData[i] = chartJsonArray[i].value;
    labelData[i] = chartJsonArray[i].label;
    console.log(labelData[i]+" "+labelData[i])
}

new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#ff66cc","#44cc00","#2952a3"],
            borderColor: 'rgb(55, 99, 132)',
            data: numericData
        }]
    },

    // Configuration options go here
     options: {
    	title : {
    		display : true,
    		text : 'Project Status'
    	}
    }
});

function decodeHtml(html){
	var txt = document.createElement("textArea");
	txt.innerHTML = html;
	return txt.value;
}