const MetricCard = ({ title, value }) => {
  return (
    <div style={{
      border: "1px solid #ddd",
      padding: "15px",
      borderRadius: "10px",
      width: "160px",
      textAlign: "center",
      background: "#f9f9f9"
    }}>
      <h4>{title}</h4>
      <p style={{ fontSize: "20px", fontWeight: "bold" }}>{value}</p>
    </div>
  );
};

export default MetricCard;