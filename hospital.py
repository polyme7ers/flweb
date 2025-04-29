# Hospital Expert System - Yes/No Version

class ExpertSystem:
    def __init__(self):
        # List of symptoms we will ask about
        self.symptom_list = [
            "fever",
            "cough",
            "shortness of breath",
            "chest pain",
            "sore throat",
            "runny nose",
            "headache",
            "nausea",
            "sensitivity to light",
            "sweating",
            "frequent urination",
            "increased thirst",
            "fatigue",
            "blurred vision"
        ]

        # Mapping diseases to their key symptoms
        self.diseases = {
            "Pneumonia": {"fever", "cough", "shortness of breath", "chest pain"},
            "Common Cold": {"fever", "sore throat", "runny nose"},
            "Migraine": {"headache", "nausea", "sensitivity to light"},
            "Heart Attack": {"chest pain", "shortness of breath", "sweating", "nausea"},
            "Diabetes": {"frequent urination", "increased thirst", "fatigue", "blurred vision"}
        }

        self.recommendations = {
            "Pneumonia": "Chest X-Ray, antibiotics, and hospital care if severe.",
            "Common Cold": "Rest at home, drink plenty of fluids.",
            "Migraine": "Pain relief, rest in a dark quiet place.",
            "Heart Attack": "Call emergency services immediately!",
            "Diabetes": "Consult a doctor for blood sugar tests."
        }

    def get_patient_symptoms(self):
        patient_symptoms = set()

        print("\n🏥 Please answer the following questions with 'yes' or 'no':\n")
        for symptom in self.symptom_list:
            response = input(f"Do you have {symptom}? (yes/no): ").lower()
            while response not in ("yes", "no"):
                response = input("Please answer 'yes' or 'no': ").lower()

            if response == "yes":
                patient_symptoms.add(symptom)

        return patient_symptoms

    def diagnose(self, patient_symptoms):
        diagnosis = []

        for disease, symptoms in self.diseases.items():
            match_count = len(patient_symptoms & symptoms)
            total_symptoms = len(symptoms)
            confidence = (match_count / total_symptoms) * 100

            if confidence > 0:
                diagnosis.append({
                    "disease": disease,
                    "confidence": round(confidence, 2),
                    "recommendation": self.recommendations[disease]
                })

        diagnosis.sort(key=lambda x: x["confidence"], reverse=True)
        return diagnosis

def main():
    print("\n🔵 Welcome to the Hospital Expert System 🔵")

    system = ExpertSystem()
    patient_symptoms = system.get_patient_symptoms()
    results = system.diagnose(patient_symptoms)

    print("\n📋 Diagnosis Results:\n")
    if not results:
        print("❗ No disease matched. Please consult a doctor.")
    else:
        for result in results:
            print(f"- Disease: {result['disease']}")
            print(f"  Match Confidence: {result['confidence']}%")
            print(f"  Recommendation: {result['recommendation']}\n")

if __name__ == "__main__":
    main()