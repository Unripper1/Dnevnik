function showActivityStat(number, n1, n2, n3, n4) {
    // Doughnut chart
    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
        // type: 'doughnut',
        type: 'pie',
        data: {
            labels: ['Хобби', 'Общение', 'Спорт', 'Учеба', 'Работа'],
            datasets: [{
                data: [parseFloat(number), parseFloat(n1), parseFloat(n2), parseFloat(n3), parseFloat(n4)],
                backgroundColor: ['#e91e63', '#00e676', '#ff5722', '#1e88e5', '#ffd600'],
                borderWidth: 0.5 ,
                borderColor: '#ddd'
            }]
        },
        options: {
            title: {
                display: true,
                text: 'Аналитика активности за всё время',
                position: 'top',
                fontSize: 16,
                fontColor: '#111',
                padding: 20
            },
            legend: {
                display: true,
                position: 'bottom',
                labels: {
                    boxWidth: 20,
                    fontColor: '#111',
                    padding: 15
                }
            },
            tooltips: {
                enabled: false
            },
            plugins: {
                datalabels: {
                    color: '#111',
                    textAlign: 'center',
                    font: {
                        lineHeight: 1.6
                    },
                    formatter: function(value, ctx) {
                        return ctx.chart.data.labels[ctx.dataIndex] + '\n' + value + '%';
                    }
                }
            }
        }
    });
}


function showMoodStat(number, n1, n2, n3, n4) {
    // alert(`${number}`);
    // Doughnut chart
    var ctx = document.getElementById('myChart2').getContext('2d');
    var myChart = new Chart(ctx, {
        // type: 'doughnut',
        type: 'pie',
        data: {
            labels: ['Отлично', 'Хорошо', 'Нормально', 'Плохо', 'Очень плохо'],
            datasets: [{
                data: [parseFloat(number), parseFloat(n1), parseFloat(n2), parseFloat(n3), parseFloat(n4)],
                backgroundColor: ['#e91e63', '#00e676', '#ff5722', '#1e88e5', '#ffd600'],
                borderWidth: 0.5 ,
                borderColor: '#ddd'
            }]
        },
        options: {
            title: {
                display: true,
                text: 'Аналитика настроения за всё время',
                position: 'top',
                fontSize: 16,
                fontColor: '#111',
                padding: 20
            },
            legend: {
                display: true,
                position: 'bottom',
                labels: {
                    boxWidth: 20,
                    fontColor: '#111',
                    padding: 15
                }
            },
            tooltips: {
                enabled: false
            },
            plugins: {
                datalabels: {
                    color: '#111',
                    textAlign: 'center',
                    font: {
                        lineHeight: 1.6
                    },
                    formatter: function(value, ctx) {
                        return ctx.chart.data.labels[ctx.dataIndex] + '\n' + value + '%';
                    }
                }
            }
        }
    });
}


// window.onload = showActivityStat;