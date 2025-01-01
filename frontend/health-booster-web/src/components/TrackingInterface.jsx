import React, { useState } from 'react';
import axios from 'axios';

const TrackingInterface = () => {
  const [activity, setActivity] = useState('');
  const [duration, setDuration] = useState('');
  const [calories, setCalories] = useState(null);
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);
  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError('');
    setCalories(null);
    try {
      const response = await axios.get('https://api.api-ninjas.com/v1/caloriesburned', {
        params: {
          activity: activity,
          duration: duration,
          weight: 150
        },
        headers: {
          'X-Api-Key': "Mx6uI8mZiUq/UX8ijHbg/g==kjVS1PNDuBj8indN"
        }
      });
      
      if (response.data && response.data.length > 0) {
        setCalories(response.data[0].total_calories);
        axios.post('http://localhost:8080/api/workouts/'), {
          activity: activity,
          duration: duration,
          calories: response.data[0].total_calories
        };
      } else {
        setError('No calorie data found for this activity');
      }
    } catch (err) {
      setError('Failed to fetch calorie data. Please try again.');
      console.error('API call error:', err);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div style={styles.container}>
      {/* Activity Tracking Section */}
      <div style={styles.section}>
        <h2>Track Activity</h2>
        <form onSubmit={handleSubmit}>
          <div style={styles.inputGroup}>
            <label htmlFor="activity">Activity Type</label>
            <input
              type="text"
              id="activity"
              value={activity}
              onChange={(e) => setActivity(e.target.value)}
              placeholder="Enter an activity (e.g., running, swimming)"
              style={styles.input}
            />
          </div>
          
          <div style={styles.inputGroup}>
            <label htmlFor="duration">Duration (minutes)</label>
            <input 
              type="number"
              id="duration"
              value={duration}
              onChange={(e) => setDuration(e.target.value)}
              placeholder="Enter duration"
              style={styles.input}
            />
          </div>
          
          <button 
            type="submit" 
            style={styles.button}
            disabled={loading}
          >
            {loading ? 'Calculating...' : 'Calculate Calories'}
          </button>
        </form>

        {calories && (
          <div style={styles.result}>
            Calories burned: {calories}
          </div>
        )}

        {error && (
          <div style={styles.error}>
            {error}
          </div>
        )}
      </div>
         {/* Meal Tracking Section */}
         <div style={styles.section}>
         <h2>Track Meal</h2>
         <div style={styles.inputGroup}>
           <label htmlFor="meal">Meal Type</label>
           <select id="meal" style={styles.input}>
             <option value="">Select a meal</option>
             <option value="chicken">Chicken</option>
             <option value="beef">Beef</option>
           </select>
         </div>
         
         <div style={styles.inputGroup}>
           <label htmlFor="servings">Number of Servings</label>
           <input 
             type="number" 
             id="servings" 
             placeholder="Enter servings"
             style={styles.input}
           />
         </div>
         
         <button style={styles.button}>Log Meal</button>
       </div>
     </div>
  );
};

const styles = {
  container: {
    maxWidth: '600px',
    margin: '20px auto',
    padding: '20px'
  },
  section: {
    marginBottom: '30px',
    padding: '15px',
    border: '1px solid #ccc',
    borderRadius: '5px'
  },
  inputGroup: {
    marginBottom: '15px'
  },
  input: {
    width: '100%',
    padding: '8px',
    marginTop: '5px',
    border: '1px solid #ccc',
    borderRadius: '4px'
  },
  button: {
    width: '100%',
    padding: '10px',
    backgroundColor: '#007bff',
    color: 'white',
    border: 'none',
    borderRadius: '4px',
    cursor: 'pointer'
  },
  result: {
    marginTop: '15px',
    padding: '10px',
    backgroundColor: '#e8f5e9',
    borderRadius: '4px',
    textAlign: 'center'
  },
  error: {
    marginTop: '15px',
    padding: '10px',
    backgroundColor: '#ffebee',
    color: '#c62828',
    borderRadius: '4px',
    textAlign: 'center'
  }
};

export default TrackingInterface;