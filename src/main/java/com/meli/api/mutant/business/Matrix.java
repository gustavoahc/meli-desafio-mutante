package com.meli.api.mutant.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.meli.api.mutant.business.MutantVariable.ALLOWED_LETTERS;
import static com.meli.api.mutant.business.MutantVariable.MIN_MUTANT_SIZE;

public class Matrix {

	private int rows;
	private int columns;
	private List<String> data;
	private char[][] dna;
	private int secuences;

	public Matrix(List<String> sequence) {
		String[] array = sequence.toArray(new String[0]);
		this.data = new ArrayList<String>(Arrays.asList(array));
	}

	public boolean validateMatrix() throws Exception 
	{
		this.rows = this.data.size();

		this.validateSize();

		this.validateDnaSequence();

		this.columns = this.data.size();
		this.dna = new char[this.rows][this.columns];
		String row;

		for (int i = 0; i < this.rows; i++) {
			row = this.data.get(i);

			// Validate row
			this.validateRow(row);

			for (int j = 0; j < this.columns; j++) {
				if (this.validateLetter(row.charAt(j))) {
					this.dna[i][j] = row.charAt(j);
				} else {
					throw new Exception("Only A, T, C, G are valid letters!!!");
				}
			}
		}

		if (this.secuences <= 1) {
			for (int j = 0; j < this.columns; j++) {
				this.validateColumn(j);
			}
		}

		if (this.secuences <= 1) {
			this.validateDiagonal1();
		}

		if (this.secuences <= 1) {
			this.validateDiagonal2();
		}

		if (this.secuences <= 1) {
			this.validateReverseDiagonal1();
		}

		if (this.secuences <= 1) {
			this.validateReverseDiagonal2();
		}

		if (this.secuences > 1) {
			return true;
		} else {
			return false;
		}
	}

	private void validateSize() throws Exception {
		if (this.rows < MIN_MUTANT_SIZE) {
			throw new Exception("Invalid DNA size!!!");
		}
	}

	private void validateDnaSequence() throws Exception {
		int dimmensionRow = this.rows;
		for (int i = 0; i < this.rows; i++) {
			if (this.data.get(i).length() != dimmensionRow) {
				throw new Exception("Invalid DNA sequence!!!");
			}
		}
	}

	private boolean validateLetter(char letter) {
		if (ALLOWED_LETTERS.indexOf(Character.toLowerCase(letter)) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	private void validateRow(String row) {
		int quantity = 0;

		for (int i = 0; i < row.length() - 1; i++) {
			for (int j = i; j < row.length(); j++) {
				if (Character.toLowerCase(row.charAt(i)) == Character.toLowerCase(row.charAt(j))) {
					quantity++;
				} else {
					quantity = 0;
					break;
				}

				if (quantity >= MIN_MUTANT_SIZE) {
					this.secuences++;
					quantity = 0;
				}
			}
			quantity = 0;
		}
	}

	private void validateColumn(int column) {
		int quantity = 0;

		for (int i = 0; i < this.rows - 1; i++) {
			for (int j = i; j < this.rows; j++) {
				if (Character.toLowerCase(dna[i][column]) == Character.toLowerCase(dna[j][column])) {
					quantity++;
				} else {
					quantity = 0;
					break;
				}

				if (quantity >= MIN_MUTANT_SIZE) {
					this.secuences++;
					quantity = 0;
				}
			}
			quantity = 0;
		}
	}

	private void validateDiagonal1() {
		int limitSize = this.rows - MIN_MUTANT_SIZE;

		for (int i = 0; i <= limitSize; i++) {
			StringBuilder diagonal = new StringBuilder();
			int l = i;

			for (int j = 0; j <= this.rows - 1 - i; j++) {
				diagonal.append(dna[l][j]);
				l++;
			}

			this.validateRow(diagonal.toString());
		}
	}

	private void validateDiagonal2() {
		int limitSize = this.rows - MIN_MUTANT_SIZE;

		for (int j = 1; j <= limitSize; j++) {
			StringBuilder diagonal = new StringBuilder();
			int l = j;

			for (int i = 0; i <= this.rows - 1 - j; i++) {
				diagonal.append(dna[i][l]);
				l++;
			}

			this.validateRow(diagonal.toString());
		}
	}

	private void validateReverseDiagonal1() {
		int limitSize = this.rows - MIN_MUTANT_SIZE;

		for (int i = 0; i <= limitSize; i++) {
			StringBuilder diagonal = new StringBuilder();
			int l = i;

			for (int j = this.rows - 1; j >= 0 + i; j--) {
				diagonal.append(dna[l][j]);
				l++;
			}

			this.validateRow(diagonal.toString());
		}
	}

	private void validateReverseDiagonal2() {
		int k = 0;
		for (int j = this.rows - 2; j >= MIN_MUTANT_SIZE - 1; j--) {
			StringBuilder diagonal = new StringBuilder();
			int l = j;

			for (int i = 0; i <= this.rows - 2 - k; i++) {
				diagonal.append(dna[i][l]);
				l--;
			}

			this.validateRow(diagonal.toString());
			k++;
		}
	}

}