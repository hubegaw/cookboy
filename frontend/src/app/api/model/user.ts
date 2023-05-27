/**
 * Cookbook API
 * API endpoints for recipes, authentication, and user management
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
import { Recipe } from './recipe';
import { Token } from './token';


export interface User { 
    id?: number;
    name?: string;
    email?: string;
    password?: string;
    role?: string;
    tokens?: Array<Token>;
    recipes?: Array<Recipe>;
}
