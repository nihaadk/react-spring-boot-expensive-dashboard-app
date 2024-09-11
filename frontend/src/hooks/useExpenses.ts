import { useEffect, useState } from "react";
import { getExpenses } from "../services/expense-service";
import { Expense } from "../interfaces/expense.interface";

const useExpenses = () => {
  const [expenses, setExpenses] = useState<Expense[]>([]);
  const [isLoading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    setLoading(true);
    getExpenses()
      .then(({ data }) => {
        setExpenses(data);
      })
      .catch((error) => setError(error.message))
      .finally(() => setLoading(false));
  }, []);

  return { expenses, isLoading, error };
};

export default useExpenses;
