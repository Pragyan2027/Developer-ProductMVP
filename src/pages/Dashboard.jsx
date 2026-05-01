import { useEffect, useState } from "react";
import { fetchMetrics } from "../services/api";
import MetricCard from "../components/MetricCard";
import InsightsPanel from "../components/InsightsPanel";
import SuggestionsPanel from "../components/SuggestionsPanel";

const Dashboard = () => {
  const [data, setData] = useState(null);

  useEffect(() => {
    fetchMetrics()
      .then(res => setData(res.data))
      .catch(err => console.error(err));
  }, []);

  if (!data) return <h2>Loading...</h2>;

  return (
    <div style={{ padding: "20px" }}>
      <h1>Developer Productivity Dashboard</h1>

      {/* Metrics */}
      <div style={{
        display: "flex",
        gap: "20px",
        marginTop: "20px"
      }}>
        <MetricCard title="Lead Time" value={data.leadTime} />
        <MetricCard title="Cycle Time" value={data.cycleTime} />
        <MetricCard title="Bug Rate" value={data.bugRate} />
        <MetricCard title="Deployments" value={data.deploymentFrequency} />
        <MetricCard title="PR Throughput" value={data.prThroughput} />
      </div>

      {/* Insights */}
      <InsightsPanel insights={data.insights} />

      {/* Suggestions */}
      <SuggestionsPanel suggestions={data.suggestions} />
    </div>
  );
};

export default Dashboard;