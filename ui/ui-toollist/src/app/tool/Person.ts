export default class Person {
  private _dms: string;
  private _rev: number;
  private _coolant: string;
  private _latheProgramm: string;
  private _design: string;
  private _approve: string;
  private _date: string;
  private _material: string;
  private _block: string;
  private _operation: string;
  private _fixture: string;
  private _machine: string;
  private _airfoilType: string;


  get dms(): string {
    return this._dms;
  }

  set dms(value: string) {
    this._dms = value;
  }

  get rev(): number {
    return this._rev;
  }

  set rev(value: number) {
    this._rev = value;
  }

  get coolant(): string {
    return this._coolant;
  }

  set coolant(value: string) {
    this._coolant = value;
  }

  get latheProgramm(): string {
    return this._latheProgramm;
  }

  set latheProgramm(value: string) {
    this._latheProgramm = value;
  }

  get design(): string {
    return this._design;
  }

  set design(value: string) {
    this._design = value;
  }

  get approve(): string {
    return this._approve;
  }

  set approve(value: string) {
    this._approve = value;
  }

  get date(): string {
    return this._date;
  }

  set date(value: string) {
    this._date = value;
  }

  get material(): string {
    return this._material;
  }

  set material(value: string) {
    this._material = value;
  }

  get block(): string {
    return this._block;
  }

  set block(value: string) {
    this._block = value;
  }

  get operation(): string {
    return this._operation;
  }

  set operation(value: string) {
    this._operation = value;
  }

  get fixture(): string {
    return this._fixture;
  }

  set fixture(value: string) {
    this._fixture = value;
  }

  get machine(): string {
    return this._machine;
  }

  set machine(value: string) {
    this._machine = value;
  }

  get airfoilType(): string {
    return this._airfoilType;
  }

  set airfoilType(value: string) {
    this._airfoilType = value;
  }

  constructor(dms: string, rev: number, coolant: string, latheProgramm: string, design: string, approve: string, date: string, material: string, block: string, operation: string, fixture: string, machine: string, airfoilType: string) {
    this._dms = dms;
    this._rev = rev;
    this._coolant = coolant;
    this._latheProgramm = latheProgramm;
    this._design = design;
    this._approve = approve;
    this._date = date;
    this._material = material;
    this._block = block;
    this._operation = operation;
    this._fixture = fixture;
    this._machine = machine;
    this._airfoilType = airfoilType;
  }
}


