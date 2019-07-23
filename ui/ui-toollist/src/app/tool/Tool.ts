export default class Tool{
  private _toolnumber: number;
  private _description: string;
  private _partnumtj: string;
  private _holder: string;
  private _hight: number;
  private _f: number;
  private _s: number;
  private _offset: string;
  private _d: number;
  private _toollife;

  get toolnumber(): number {
    return this._toolnumber;
  }

  set toolnumber(value: number) {
    this._toolnumber = value;
  }

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }

  get partnumtj(): string {
    return this._partnumtj;
  }

  set partnumtj(value: string) {
    this._partnumtj = value;
  }

  get holder(): string {
    return this._holder;
  }

  set holder(value: string) {
    this._holder = value;
  }

  get hight(): number {
    return this._hight;
  }

  set hight(value: number) {
    this._hight = value;
  }

  get f(): number {
    return this._f;
  }

  set f(value: number) {
    this._f = value;
  }

  get s(): number {
    return this._s;
  }

  set s(value: number) {
    this._s = value;
  }

  get offset(): string {
    return this._offset;
  }

  set offset(value: string) {
    this._offset = value;
  }

  get d(): number {
    return this._d;
  }

  set d(value: number) {
    this._d = value;
  }

  get toollife() {
    return this._toollife;
  }

  set toollife(value) {
    this._toollife = value;
  }

  constructor(toolnumber: number, description: string, partnumtj: string, holder: string, hight: number, f: number, s: number, offset: string, d: number, toollife) {
    this._toolnumber = toolnumber;
    this._description = description;
    this._partnumtj = partnumtj;
    this._holder = holder;
    this._hight = hight;
    this._f = f;
    this._s = s;
    this._offset = offset;
    this._d = d;
    this._toollife = toollife;
  }
}
