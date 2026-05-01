const SuggestionsPanel = ({ suggestions }) => {
  return (
    <div style={{ marginTop: "30px" }}>
      <h2>Suggestions</h2>
      <ul>
        {suggestions.map((s, index) => (
          <li key={index}>{s}</li>
        ))}
      </ul>
    </div>
  );
};

export default SuggestionsPanel;