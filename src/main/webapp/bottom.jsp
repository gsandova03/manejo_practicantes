</div>
</section>

        <script>
            let arrow = document.querySelectorAll(".arrow");
            for (var i = 0; i < arrow.length; i++) {
                arrow[i].addEventListener("click", (e) => {
                    let arrowParent = e.target.parentElement.parentElement;
                    arrowParent.classList.toggle("showMenu");
                });
            }

            let sidebar = document.querySelector(".sidebar");
            let sidebarBtn = document.querySelector(".bx-menu");


            sidebarBtn.addEventListener("click", () => {
                sidebar.classList.toggle("close");
            });


        </script>
        <script>
            var ctx = document.getElementById("barra").getContext("2d");
            var myChart = new Chart(ctx, {

                type: "bar",
                data: {
                    labels: ['alto', 'medio', 'bajo'],
                    datasets: [{

                            label: 'Grafica De Barras',

                            data: [3, 4, 5],

                            backgroundColor: [
                                'rgb(217, 136, 128)',
                                'rgb(241, 148, 138)',
                                'rgb( 195, 155, 211 )',
                                'rgb( 133, 193, 233 )',
                                'rgb( 118, 215, 196 )',
                                'rgb(125, 206, 160)',
                                'rgb(247, 220, 111)',
                                'rgb( 240, 178, 122 )',
                                'rgb( 215, 219, 221 )',
                                'rgb( 133, 146, 158 )',
                            ]
                        }]
                },
                options: {
                    scales: {
                        yAxes: [{
                                ticks: {
                                    beginAtZaero: true
                                }
                            }]
                    }
                }
            });
        </script>

        <!-- Grafica Redonda -->
        <script class="clasepie">
        var ctx = document.getElementById("pastel").getContext("2d");
        var myChart = new Chart(ctx, {

            type: "pie",
            data: {
                labels: ['alto', 'medio', 'bajo'],
                datasets: [{

                        data: [3, 4, 5],
                        backgroundColor: [
                            'rgb(217, 136, 128)',
                            'rgb(241, 148, 138)',
                            'rgb( 195, 155, 211 )',
                            'rgb( 133, 193, 233 )',
                            'rgb( 118, 215, 196 )',
                            'rgb(125, 206, 160)',
                            'rgb(247, 220, 111)',
                            'rgb( 240, 178, 122 )',
                            'rgb( 215, 219, 221 )',
                            'rgb( 133, 146, 158 )',
                        ]
                    }]
            },
            options: {
                scales: {
                    yAxes: [{
                            ticks: {
                                beginAtZaero: true
                            }
                        }]
                }
            }
        });
        </script>
        <script>

            var ctx = document.getElementById("linea").getContext("2d");
            var myChart = new Chart(ctx, {

                type: "line",
                data: {
                    labels: ['alto', 'medio', 'bajo'],
                    datasets: [{
                            label: 'Grafica En linea',
                            data: [3, 4, 5],
                            backgroundColor: [

                                'rgb(217, 136, 128)',
                                'rgb(241, 148, 138)',
                                'rgb( 195, 155, 211 )',
                                'rgb( 133, 193, 233 )',
                                'rgb( 118, 215, 196 )',
                                'rgb(125, 206, 160)',
                                'rgb(247, 220, 111)',
                                'rgb( 240, 178, 122 )',
                                'rgb( 215, 219, 221 )',
                                'rgb( 133, 146, 158 )',
                            ]
                        }]
                },
                options: {
                    scales: {
                        yAxes: [{
                                ticks: {
                                    beginAtZaero: true
                                }
                            }]
                    }
                }
            });
        </script>
    </body>

</html>