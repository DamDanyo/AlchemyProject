export class Potions {
        
    //this constructor will initialize the Potion's variable when we get it from the API
    constructor(
        public name: string,
        public description: string,
        public id: number,
        public potionvalue: number,
        public potionquantity: number
    ){}

}
