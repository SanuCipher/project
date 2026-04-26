<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>

<body>

<h2 style="text-align:center;">📊 Fee Chart</h2>

<canvas id="myChart"></canvas>

<script>
fetch('chartdata')
.then(res => res.json())
.then(data => {
    new Chart(document.getElementById('myChart'), {
        type: 'bar',
        data: {
            labels: data.names,
            datasets: [{
                label: 'Fees',
                data: data.amounts
            }]
        }
    });
});
</script>

</body>
</html>