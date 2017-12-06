package model.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import model.words.PartOfSpeech;
import model.words.ReadWordFailedException;
import model.words.Word;
import model.words.WordRepository;
import model.words.WordXMLRepository;


public class QuestionManger {

	private List<Question> questions = new ArrayList<Question>();

	public QuestionManger(WordRepository wordRepository) {
		createQuestions(wordRepository);
	}
	
	private void createQuestions(WordRepository wordRepository) {
		try {
			List<Word> words = wordRepository.readAllWord();
			Collections.shuffle(words);
			for (Word word : words) {
				String wordtxt = word.getWord();
				String soundPath = word.getSoundPath();
				Map<String, List<String>> definitions = word.getSentences();
				List<String> partOfSpeechs = new ArrayList<>(definitions.keySet());
				String partOfSpeech = partOfSpeechs.get(0);
				String definition = word.getSentence(partOfSpeech);
				Question question = new Question(wordtxt, soundPath, partOfSpeech, definition);
				questions.add(question);
			}
		} catch (ReadWordFailedException e) {
			e.printStackTrace();
		}
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
	
	public Question getQuestion(int index) {
		return questions.get(index);
	}
	
	public int getAllQuestionAmount() {
		return questions.size();
	}
	
	public static void main(String[] argv) {
		QuestionManger questionManger = new QuestionManger(new WordXMLRepository("words"));
		List<Question> questions = questionManger.getQuestions();
		for (Question question : questions) {
			System.out.println(question.getWord() + question.getPartOfSpeech() + question.getDefinition());
		}
	}
	
}
