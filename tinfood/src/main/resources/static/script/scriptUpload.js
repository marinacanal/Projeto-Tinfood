const input = document.getElementById("input-file");
const image = document.getElementById("image-selected");
//CAPTURAMOS LA IMAGEN SELECCIONADA
input.addEventListener("change", (e) => {
  console.log(e.target.files[0]);
  let imageBinary = null;
//LEEMOS EL BINARIO DE LA IMAGEN
const reader = new FileReader();
      reader.readAsDataURL(e.target.files[0]);
      reader.onload = (e) => {
        e.preventDefault();
        image.setAttribute('src', e.target.result)
       };
     });