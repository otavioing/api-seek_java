document.addEventListener("DOMContentLoaded", function() {

    const tipo = document.getElementById("tipo");
    const divProf = document.getElementById("divProf");
    const divBusiness = document.getElementById("divBusiness");

    function chngInput() {

        divProf.style.display = "none";
        divBusiness.style.display = "none";

        if (tipo.value === "professor") {
            divProf.style.display = "flex";
        } else if (tipo.value === "empresa") {
            divBusiness.style.display = "flex";
        }
    }

    tipo.addEventListener("change", chngInput);

    chngInput();
});