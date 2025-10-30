import React, { useEffect, useState } from 'react';
import { API_BASE } from '../lib/api';

/*
    Edit component (demo-friendly comments)

    Responsibilities & behavior:
    - Renders a controlled form pre-filled from the `pet` prop so users can
        edit an existing pet (petId, name, type).
    - Fetches available pet types from GET /api/pet/types and shows them in a
        dropdown. The dropdown is preselected to the pet's current type via
        the formData initialized from `pet`.
    - If the types endpoint is unavailable, the component falls back to a
        free-text input for the type field so edits can proceed.
    - Submits updates via PUT /api/pet with the payload { petId, name, type }.
    - Calls onSuccess() when the update succeeds so the parent can hide the
        form and refresh the table.

    Demo talking points:
    - Using props to prefill forms (controlled inputs + useEffect).
    - Reusing the same types datasource as the Add form for consistent UX.
    - Graceful degradation: dropdown -> text input fallback.
*/
function Edit({ pet, onCancel, onSuccess }) {
    const [formData, setFormData] = useState({ petId: '', name: '', type: '' });
    const [status, setStatus] = useState({ loading: false, error: '', success: false });
    // Types fetched from the API for the Type dropdown
    const [petTypes, setPetTypes] = useState([]);
    const [loadingTypes, setLoadingTypes] = useState(true);
    const [typesError, setTypesError] = useState('');

    // When the selected pet changes (or on mount), populate the form
    useEffect(() => {
        if (pet) {
            setFormData({ petId: pet.petId ?? '', name: pet.name ?? '', type: pet.type ?? '' });
        }
    }, [pet]);

    // Load pet types so the edit form can show a dropdown.
    // We expect an array of strings from the server. If that fails we
    // fall back to a text input so the user can still update the pet.
    useEffect(() => {
        let mounted = true;
        async function loadTypes() {
           alert("Call the API");
        }

        loadTypes();
        return () => { mounted = false; };
    }, []);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData(prev => ({ ...prev, [name]: value }));
    };

    // Submit the updated pet to the API via PUT
    const handleSubmit = async (e) => {
       alert("Call the API");
    };

    // If no pet is provided, render nothing
    if (!pet) return null; // nothing to edit

    return (
        <div className="pet-form-wrapper mt-4">
            <h2>Edit Pet</h2>
            <form onSubmit={handleSubmit} className="mb-4">
                {/* petId is sent but not editable in the UI */}
                <input type="hidden" name="petId" value={formData.petId} />

                <div className="mb-3">
                    <label htmlFor="name" className="form-label">Pet Name</label>
                    <input
                        type="text"
                        className="form-control"
                        id="name"
                        name="name"
                        value={formData.name}
                        onChange={handleChange}
                        required
                        minLength="2"
                        maxLength="50"
                        disabled={status.loading}
                    />
                </div>

                <div className="mb-3">
                    <label htmlFor="type" className="form-label">Pet Type</label>
                    {loadingTypes ? (
                        <select className="form-select" id="type" name="type" disabled>
                            <option>Loading types...</option>
                        </select>
                    ) : typesError ? (
                        // Fallback to free text if the types endpoint isn't available
                        <input
                            type="text"
                            className="form-control"
                            id="type"
                            name="type"
                            value={formData.type}
                            onChange={handleChange}
                            required
                            minLength="2"
                            maxLength="50"
                            disabled={status.loading}
                        />
                    ) : (
                        <select
                            className="form-select"
                            id="type"
                            name="type"
                            value={formData.type}
                            onChange={handleChange}
                            required
                            disabled={status.loading}
                        >
                            <option value="" disabled>Choose a type...</option>
                            {petTypes.map(t => (
                                <option key={t} value={t}>{t}</option>
                            ))}
                        </select>
                    )}
                </div>

                <div className="d-flex gap-2">
                    <button type="submit" className="btn btn-primary" disabled={status.loading}>
                        {status.loading ? (
                            <>
                                <span className="spinner-border spinner-border-sm me-2" role="status" aria-hidden="true"></span>
                                Updating...
                            </>
                        ) : 'Update Pet'}
                    </button>

                    <button type="button" className="btn btn-secondary" onClick={onCancel} disabled={status.loading}>
                        Cancel
                    </button>
                </div>
            </form>

            {status.error && (
                <div className="alert alert-danger" role="alert">
                    {status.error}
                </div>
            )}
        </div>
    );
}

export default Edit;
