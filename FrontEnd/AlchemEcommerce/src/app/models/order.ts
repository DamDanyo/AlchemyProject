export class Order {
  constructor(
    useridFK: {},
    public userid: number,
    public username: string,
    public password: string,
    public isadmin: true,
    public orderaddress: string,
    public ordertotal: number,
    public items: number,
    public itemsquantity: number
  ) {}
}
export class newOrder {
  constructor(
    userid: number,
    orderaddress: string,
    ordertotal: number,
    items: number[],
    itemsquantity: number[]
  ) {}
}
