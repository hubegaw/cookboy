export * from './api.service';
import { ApiService } from './api.service';
export * from './auth.service';
import { AuthService } from './auth.service';
export const APIS = [ApiService, AuthService];
