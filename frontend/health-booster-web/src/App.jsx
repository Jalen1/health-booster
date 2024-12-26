import React from 'react';
import AppRoutes from './routes/AppRoutes';
import Header from './components/Header';
import './styles/App.css';

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
