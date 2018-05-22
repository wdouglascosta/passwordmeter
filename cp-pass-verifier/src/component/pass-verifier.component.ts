export class CapivaraPassVerifier {
    public $constants;
    public $functions;
    public $bindings;

    private componentName: string;
    private visibleMessage: boolean;

    private password;
    private rate = 0;
    private complex;
    constructor(){
    }

    searchRate(){
        this.getFromApi("http://localhost:8080/verify").then((resp)=>{
            this.rate = resp;
        })
    }

    $onChanges(){
        this.complexCalc();
    }

    complexCalc(){
        if(this.rate < 20){
            this.complex = "Muito Fraca"
            document.getElementById("x1").classList.add("pv_div_vw")
            document.getElementById("x1").classList.remove("pv_div_w")
        }
        if((this.rate > 20) && (this.rate < 40)){
            this.complex = "Fraca"
            document.getElementById("x1").classList.remove("pv_div_vw")
            document.getElementById("x1").classList.add("pv_div_w")
            document.getElementById("x1").classList.remove("pv_div_m")
        }
        if((this.rate > 40) && (this.rate < 60)){
            this.complex = "Ok"
            document.getElementById("x1").classList.remove("pv_div_w")
            document.getElementById("x1").classList.add("pv_div_m")
            document.getElementById("x1").classList.remove("pv_div_s")
        }
        if((this.rate > 60) && (this.rate < 80)){
            this.complex = "Forte"
            document.getElementById("x1").classList.remove("pv_div_m")
            document.getElementById("x1").classList.add("pv_div_s")
            document.getElementById("x1").classList.remove("pv_div_vs")
        }
        if(this.rate > 80){
            this.complex = "Muito Forte"
            document.getElementById("x1").classList.remove("pv_div_s")
            document.getElementById("x1").classList.add("pv_div_vs")
        }
    }

    toogleMessage(){
        this.visibleMessage = !this.visibleMessage;
    }
    
    getFromApi(url: string): Promise<any> {
        return new Promise((resp, rej) => {
            const httpReq = new XMLHttpRequest();
            httpReq.onload = () => {
                if (httpReq.status === 200) {
                    resp(JSON.parse(httpReq.responseText));
                } else {
                    rej(JSON.parse(httpReq.statusText));
                }
            }
            httpReq.open("GET", url, true);
            httpReq.setRequestHeader("password", this.password)
            httpReq.send();
        });
    }

}