$(document).ready(function() {
	'use strict';
	// ------------------------------------------------------- //
	// Line Chart 1
	// ------------------------------------------------------ //
	var LINECHART1 = $('#lineChartExample1');
	var myLineChart = new Chart(LINECHART1, {
		type: 'line',
		options: {
			scales: {
				xAxes: [{
					display: true,
					gridLines: {
						display: false
					}
				}],
				yAxes: [{
					ticks: {
						max: 40,
						min: 0,
						stepSize: 0.5
					},
					display: false,
					gridLines: {
						display: false
					}
				}]
			},
			legend: {
				display: false
			}
		},
		data: {
			labels: ["2019.02.05", "2019.05.30", "2020.05.1", "2020.06.02", "2020.06.06", "2021.03.21", "2020.12.14"],
			datasets: [{
				label: "Total Overdue",
				fill: true,
				lineTension: 0,
				backgroundColor: "transparent",
				borderColor: '#6ccef0',
				pointBorderColor: '#59c2e6',
				pointHoverBackgroundColor: '#59c2e6',
				borderCapStyle: 'butt',
				borderDash: [],
				borderDashOffset: 0.0,
				borderJoinStyle: 'miter',
				borderWidth: 3,
				pointBackgroundColor: "#59c2e6",
				pointBorderWidth: 0,
				pointHoverRadius: 4,
				pointHoverBorderColor: "#fff",
				pointHoverBorderWidth: 0,
				pointRadius: 4,
				pointHitRadius: 0,
				data: [20, 28, 30, 22, 24, 10, 7],
				spanGaps: false
			}]
		}
	});

	
	// ------------------------------------------------------- //
	// Pie Chart
	// ------------------------------------------------------ //
	var PIECHARTEXMPLE = $('#pieChartExample');
	var pieChartExample = new Chart(PIECHARTEXMPLE, {
		type: 'pie',
		data: {
			labels: [
				"完成90%~100%的学生",
				"完成80%~90%的学生",
				"完成70%~80%的学生",
				"完成60%~70%的学生",
				"完成60%以下的学生"
			],
			datasets: [{
				data: [3000, 5000, 1000, 800, 50],
				borderWidth: 5,
				backgroundColor: [
					'#44b2d7',
					"#59c2e6",
					"#71d1f2",
					"#96e5ff"
				],
				hoverBackgroundColor: [
					'#44b2d7',
					"#59c2e6",
					"#71d1f2",
					"#96e5ff"
				]
			}]
		}
	});

	var pieChartExample = {
		responsive: true
	};
	// ------------------------------------------------------- //
	// Charts Gradients
	// ------------------------------------------------------ //
	var ctx1 = $("canvas").get(0).getContext("2d");
	var gradient1 = ctx1.createLinearGradient(150, 0, 150, 300);
	gradient1.addColorStop(0, 'rgba(133, 180, 242, 0.91)');
	gradient1.addColorStop(1, 'rgba(255, 119, 119, 0.94)');

	var gradient2 = ctx1.createLinearGradient(146.000, 0.000, 154.000, 300.000);
	gradient2.addColorStop(0, 'rgba(104, 179, 112, 0.85)');
	gradient2.addColorStop(1, 'rgba(76, 162, 205, 0.85)');

	var LINECHARTEXMPLE = $('#lineChartExample');
	var lineChartExample = new Chart(LINECHARTEXMPLE, {
		type: 'line',
		options: {
			legend: {
				labels: {
					fontColor: "#777",
					fontSize: 12
				}
			},
			scales: {
				xAxes: [{
					display: true,
					gridLines: {
						color: '#eee'
					}
				}],
				yAxes: [{
					display: true,
					gridLines: {
						color: '#eee'
					}
				}]
			},
		},
		data: {
			labels: ["January", "February", "March", "April", "May", "June", "July"],
			datasets: [{
					label: "今年学校整体教学完成情况%",
					fill: true,
					lineTension: 0.3,
					backgroundColor: gradient1,
					borderColor: gradient1,
					borderCapStyle: 'butt',
					borderDash: [],
					borderDashOffset: 0.0,
					borderJoinStyle: 'miter',
					borderWidth: 1,
					pointBorderColor: gradient1,
					pointBackgroundColor: "#fff",
					pointBorderWidth: 1,
					pointHoverRadius: 5,
					pointHoverBackgroundColor: gradient1,
					pointHoverBorderColor: "rgba(220,220,220,1)",
					pointHoverBorderWidth: 2,
					pointRadius: 1,
					pointHitRadius: 10,
					data: [30, 50, 40, 61, 42, 35, 40],
					spanGaps: false
				},
				{
					label: "往年学校整体教学完成情况%",
					fill: true,
					lineTension: 0.3,
					backgroundColor: gradient2,
					borderColor: gradient2,
					borderCapStyle: 'butt',
					borderDash: [],
					borderDashOffset: 0.0,
					borderJoinStyle: 'miter',
					borderWidth: 1,
					pointBorderColor: gradient2,
					pointBackgroundColor: "#fff",
					pointBorderWidth: 1,
					pointHoverRadius: 5,
					pointHoverBackgroundColor: gradient2,
					pointHoverBorderColor: "rgba(220,220,220,1)",
					pointHoverBorderWidth: 2,
					pointRadius: 1,
					pointHitRadius: 10,
					data: [50, 40, 50, 100, 45, 40, 30],
					spanGaps: false
				}
			]
		}
	});

});