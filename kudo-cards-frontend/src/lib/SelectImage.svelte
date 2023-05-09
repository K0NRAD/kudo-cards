<script>
    export let images = [];
    export let image;

    let index = images.indexOf(image);

    console.log(images)
    console.log(image)

    function nextImage() {
        index = (index + 1) % images.length;
    }

    function previousImage() {
        index = (index - 1 + images.length) % images.length;
    }
</script>

<div class="row d-flex align-items-center">
    <div class="col-10 py-2">
        <img src={images[index]} alt="" class="kudo-image img-fluid"/>
    </div>
    <div class="col-2 arrows d-flex flex-column no-screenshot">
        <button class="btn btn-transparent" on:click={previousImage}>↑</button>
        <button class="btn btn-transparent" on:click={nextImage}>↓</button>
    </div>
</div>

<style>
    .kudo-image {
        max-height: 88px;
    }
</style>
