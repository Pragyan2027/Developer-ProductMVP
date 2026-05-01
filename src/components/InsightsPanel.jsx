const InsightsPanel = ({ insights }) => {
  return (
    <div style={{ marginTop: "30px" }}>
      <h2>Insights</h2>
      <ul>
        {insights.map((insight, index) => (
          <li key={index}>{insight}</li>
        ))}
      </ul>
    </div>
  );
};

export default InsightsPanel;