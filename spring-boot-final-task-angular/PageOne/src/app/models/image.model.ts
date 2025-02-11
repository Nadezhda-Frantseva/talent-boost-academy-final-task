import {ImaggaTagModel} from "./ImaggaTag.model";

export interface Image {
  id?: number;
  url: string;
  formattedDate: string;
  service: string;
  width: number;
  height: number;
  labels: Array<ImaggaTagModel>;
  statusText: string;
  statusType: string
}
