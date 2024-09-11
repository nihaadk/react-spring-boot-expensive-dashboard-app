import { Alert, AlertTitle, Skeleton } from "@mui/material";
import useExpenses from "../hooks/useExpenses";
import ExpenseList from "../components/ExpenseList";

const Dashboard = () => {
  const { expenses, isLoading, error } = useExpenses();

  if (isLoading) {
    return (
      <>
        <Skeleton />
        <Skeleton animation="wave" />
        <Skeleton animation={false} />
      </>
    );
  }

  if (error) {
    return (
      <Alert severity="error">
        <AlertTitle>Error</AlertTitle>
        {error}
      </Alert>
    );
  }

  return <ExpenseList expenses={expenses} />;
};

export default Dashboard;
