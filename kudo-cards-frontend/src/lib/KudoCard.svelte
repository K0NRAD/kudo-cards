<script>
    import {Card, CardHeader, CardBody, CardFooter, Button} from "sveltestrap";
    import SelectImage from "./SelectImage.svelte";
    import html2canvas from "html2canvas";

    export let kudo = {};
    export let images = [];

    console.log(kudo)

    let emailTo = "";
    let emailSubject = "Meine Kudo-Karte";

    function sendKudoCard() {
        const emailBodyElement = document.querySelector("#kudo-card-content");

        const waitForRender = new Promise((resolve) => {
            requestAnimationFrame(resolve);
        });

        waitForRender.then(() => {
            setTimeout(() => {
                const shouldIgnoreElement = (element) => {
                    return element.classList.contains("no-screenshot");
                };
                const options = {
                    ignoreElements: shouldIgnoreElement,
                    preserveDrawingBuffer: true,
                    letterRendering: true,
                    allowTaint: true,
                    useCORS: true,
                    logging: false,
                };
                html2canvas(emailBodyElement, options).then((canvas) => {
                    const image = canvas.toDataURL("image/png");
                    const emailBody = `<p>Hi,</p><p>eine Karte nur für Dich:</p><img src="${image}" alt="Svelte-Karte" />`;
                    console.log(encodeURIComponent(emailBody));
                    window.open(`mailto:${emailTo}?subject=${emailSubject}&body=${encodeURIComponent(emailBody)}`);
                });
            }, 10);
        });
    }
</script>

<Card>
    <div id="kudo-card-content">
        <CardHeader>
            <h4 class="card-title">{kudo.title}</h4>
        </CardHeader>
        <CardBody>
            <SelectImage images={images} image={kudo.image}/>
            <div class="form-group mt-2">
                <input
                        type="text"
                        class="form-control"
                        id="recipient"
                        bind:value={kudo.recipient}
                        placeholder="Liebe(r) Name"
                />
            </div>
            <div class="form-group mt-2">
                <textarea
                        class="form-control"
                        id="message"
                        bind:value={kudo.message}
                        placeholder="Nachricht"
                        rows="3"
                />
            </div>
            <div class="form-group mt-2">
                <input
                        type="text"
                        class="form-control"
                        id="sender"
                        bind:value={kudo.sender}
                        placeholder="Dein(e) Name"
                />
            </div>
        </CardBody>
    </div>
    <CardFooter class="no-screenshot">
        <Button type="button" color="primary" on:click={sendKudoCard}>Kudo Karte versenden</Button>
    </CardFooter>
</Card>

<style>
    :global(.card-header) {
        background: linear-gradient(to right, rgba(238, 130, 238), rgba(156, 39, 176));
    }
</style>