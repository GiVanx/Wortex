// @flow

export type WordDTO = {
  word: string,
  pos: string
};

export type SynonymDTO = {
  text: string,
  pos: string
};

export type MeaningDTO = {
  text: string
};

export type ExampleTranslationDTO = {
  text: string
}

export type ExampleDTO = {
  text: string,
  translations: ExampleTranslationDTO[]
};

export type DefinitionDTO = {
  synonyms: SynonymDTO[],
  meanings?: MeaningDTO[],
  examples?: ExampleDTO[]
};

export type TranslationDTO = {
  word: string,
  pos: string,
  transcript: string,
  definitions: DefinitionDTO[]
}