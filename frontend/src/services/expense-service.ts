import apiClient from "../config/api-client";
import { Expense } from "../interfaces/expense.interface";

export const getExpenses = () => {
  return apiClient.get<Expense[]>("/expenses");
};
