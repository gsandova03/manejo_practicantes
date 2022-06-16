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
    
    alerta();
    function alerta(){
        var tipo = "${tipo}";
        var mensaje = "${mensaje}";
        if (tipo !== '' && tipo !== null){
            Swal.fire({
                icon: tipo,
                title: mensaje,
                timer:2000,
                showConfirmButton: false
            });
        }
    }

</script>
</body>

</html>