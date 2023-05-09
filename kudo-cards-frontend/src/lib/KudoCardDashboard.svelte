<script>
    // Importieren von Sveltestrap und Bootstrap Komponenten
    import {Container, Row, Col} from "sveltestrap";
    import "bootstrap/dist/css/bootstrap.min.css";

    // Importieren der KudoCard Komponente
    import KudoCard from "./KudoCard.svelte";

    export let kudos = [
        {
            title: "Vielen Dank",
            image: "images/thanks001.png",
            message: "",
        },
        {
            title: "Glückwunsch",
            image: "images/ok001.png",
            message: "",
        },
        {
            title: "Großartig",
            image: "images/greatjob001.png",
            message: "",
        },
        {
            title: "Super Leistung",
            image: "images/hero001.png",
            message: "",
        },
        {
            title: "Das war genial",
            image: "images/flowers001.png",
            message: "",
        },
        {
            title: "Tolle Idee",
            image: "images/bulb001.png",
            message: "",
        },
    ];

    let images = kudos.map(kudo => kudo.image)

</script>

<Container>
    <Row class="g-4">
        {#each kudos as kudo }
            <Col md="4">
                <KudoCard {images} {kudo}/>
            </Col>
        {/each}
    </Row>
</Container>
