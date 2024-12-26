import React from 'react';
import AppRoutes from './routes/AppRoutes';
import Header from './components/Header';

function App() {
  return (
    <div className="app-container">
      <Header />
      <main>
        <AppRoutes />
      </main>
    </div>
  );
}

export default App;
