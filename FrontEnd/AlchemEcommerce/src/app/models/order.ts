export class Order {

    constructor(
          
        useridFK:{},
        public userid: number,
        public username: string,
        public password: string,
        public isadmin: true,    
        public orderaddress: string,
        public ordertotal: number,   
        public items: number,
        public itemsquantity: number,
        
    ){}

}
