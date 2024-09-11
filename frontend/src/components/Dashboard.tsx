import { Skeleton } from "@mui/material";
import useExpenses from "../hooks/useExpenses";
import ExpenseList from "./ExpenseList";

const Dashboard = () => {
  const { expenses, isLoading, error } = useExpenses();
  return (
    <div>
      {isLoading && <Skeleton animation="wave" />}
      {error && <p>{error}</p>}
      <ExpenseList expenses={expenses} />
    </div>
  );
};

export default Dashboard;
