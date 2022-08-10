export class User {
  constructor(
    public userid: number,
    public username: string,
    public password: string,
    public isadmin: boolean
  ) {}
}
export class UserCreds {
  constructor(public username: string, public password: string) {}
}
