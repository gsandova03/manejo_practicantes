<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="../Javacript/validacionJs.js"></script>
        <link rel="stylesheet" href="../CSS/estilos.css"/>

        <link
            rel="stylesheet"
            href="../contrast-bootstrap-pro/css/bootstrap.min.css" />
        <link
            rel="stylesheet"
            href="../contrast-bootstrap-pro/css/cdb.css" />
        <script
        src="../contrast-bootstrap-pro/js/cdb.js"></script>
        <script
        src="../contrast-bootstrap-pro/js/bootstrap.min.js"></script>
        <script
            src="https://kit.fontawesome.com/9d1d9a82d2.js"
        crossorigin="anonymous"></script>

        <title>How to create bootstrap charts using bootstrap 5</title>
    </head>
    <style>
        .chart-container {
            width: 50%;
            height: 50%;
            margin: auto;
        }
    </style>

    <body>
        <div class="card chart-container">
            <canvas id="chart"></canvas>
        </div>

    </body>

    <script
        src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js">
    </script>
    <script>
        const ctx = document.getElementById("chart").getContext('2d');
        const myChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: ["sunday", "monday", "tuesday",
                    "wednesday", "thursday", "friday", "saturday"],
                datasets: [{
                        label: 'Last week',
                        backgroundColor: 'rgba(161, 198, 247, 1)',
                        borderColor: 'rgb(47, 128, 237)',
                        data: [3000, 4000, 2000, 5000, 8000, 9000, 2000],
                    }]
            },
            options: {
                scales: {
                    yAxes: [{
                            ticks: {
                                beginAtZero: true,
                            }
                        }]
                }
            },
        });
    </script>

    <script>
        const ctx = document.getElementById("chart").getContext('2d');
        const myChart = new Chart(ctx, {
            type: 'pie',
            data: {
                labels: ["rice", "yam", "tomato", "potato",
                    "beans", "maize", "oil"],
                datasets: [{
                        label: 'food Items',
                        backgroundColor: 'rgba(161, 198, 247, 1)',
                        borderColor: 'rgb(47, 128, 237)',
                        data: [30, 40, 20, 50, 80, 90, 20],
                    }]
            },
        });
    </script>

    <div class="progress">
        <div class="progress-bar" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">25%</div>
    </div>


</html>